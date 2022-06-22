package vn.amisoft.inventoryservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.amisoft.inventoryservice.dto.InventoryResponse;
import vn.amisoft.inventoryservice.model.Inventory;
import vn.amisoft.inventoryservice.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        List<Inventory> inventories =  inventoryRepository.findBySkuCodeIn(skuCode);
        return skuCode.stream().map( s -> {
            Optional<Inventory> inventoryOptional = inventories.stream().filter(inventory1 -> s.equals(inventory1.getSkuCode())).findFirst();
            return inventoryOptional.map(InventoryResponse::new).orElseGet(() -> new InventoryResponse(s, false));
        } ).collect(Collectors.toList());
    }
}
