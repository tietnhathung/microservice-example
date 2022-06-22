package vn.amisoft.orderservice.dto;

import lombok.Data;
import vn.amisoft.orderservice.model.OrderLineItems;

import java.beans.Transient;
import java.math.BigDecimal;

@Data
public class OrderLineItemsDto {
    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

    @Transient
    public OrderLineItems toOrderLineItems(){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(skuCode);
        orderLineItems.setPrice(price);
        orderLineItems.setQuantity(quantity);
        return orderLineItems;
    }
}
