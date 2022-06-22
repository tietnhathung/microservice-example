package vn.amisoft.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.amisoft.inventoryservice.model.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Optional<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}