package vn.amisoft.orderservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.amisoft.orderservice.dto.OrderLineItemsDto;
import vn.amisoft.orderservice.dto.OrderRequest;
import vn.amisoft.orderservice.model.Order;
import vn.amisoft.orderservice.repository.OrderRepository;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;



    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(order.getOrderNumber());
        if (orderRequest.getOrderLineItemsDtos() != null){
            order.setOrderLineItems(orderRequest.getOrderLineItemsDtos().stream().map(OrderLineItemsDto::toOrderLineItems).collect(Collectors.toList()));
        }
        orderRepository.save(order);
    }
}
