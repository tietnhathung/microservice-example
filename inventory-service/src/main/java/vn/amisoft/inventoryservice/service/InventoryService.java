package vn.amisoft.inventoryservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.amisoft.inventoryservice.model.Inventory;
import vn.amisoft.inventoryservice.repository.InventoryRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        Optional<Inventory> inventoryOptional =  inventoryRepository.findBySkuCode(skuCode);
        if (inventoryOptional.isPresent()){
            Inventory inventory = inventoryOptional.get();
            return inventory.getQuantity() > 0;
        }
        return false;
    }
}
