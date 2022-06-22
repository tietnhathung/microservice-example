package vn.amisoft.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.amisoft.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}