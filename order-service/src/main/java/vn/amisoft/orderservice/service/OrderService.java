package vn.amisoft.orderservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import vn.amisoft.orderservice.constant.ServiceConstant;
import vn.amisoft.orderservice.dto.InventoryResponse;
import vn.amisoft.orderservice.dto.OrderLineItemsDto;
import vn.amisoft.orderservice.dto.OrderRequest;
import vn.amisoft.orderservice.model.Order;
import vn.amisoft.orderservice.repository.OrderRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        if (orderRequest.getOrderLineItemsDtos() == null) {
            throw new IllegalArgumentException("product is not null");
        }

        order.setOrderLineItems(orderRequest.getOrderLineItemsDtos().stream().map(OrderLineItemsDto::toOrderLineItems).collect(Collectors.toList()));

        List<String> skuCodes = orderRequest.getOrderLineItemsDtos().stream().map(OrderLineItemsDto::getSkuCode).collect(Collectors.toList());

        InventoryResponse[] inventoryResponses = webClientBuilder.build().get().uri( ServiceConstant.INVENTORY_SERVICE.url("inventory") , uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build()).retrieve().bodyToMono(InventoryResponse[].class).block();

        if (inventoryResponses != null) {
            boolean isAllProductInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
            if (isAllProductInStock) {
                orderRepository.save(order);
                return;
            }
        }
        throw new IllegalArgumentException("product is not in stock, please try again later");
    }
}
