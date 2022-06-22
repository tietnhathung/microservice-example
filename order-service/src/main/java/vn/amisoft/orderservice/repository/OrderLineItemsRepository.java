package vn.amisoft.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.amisoft.orderservice.model.OrderLineItems;

public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, Integer> {
}