package vn.amisoft.inventoryservice.dto;

import lombok.Data;
import vn.amisoft.inventoryservice.model.Inventory;

@Data
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;

    public InventoryResponse(String skuCode, boolean isInStock) {
        this.skuCode = skuCode;
        this.isInStock = isInStock;
    }

    public InventoryResponse(Inventory inventory) {
        this.skuCode = inventory.getSkuCode();
        this.isInStock = inventory.getQuantity() > 0;
    }
}

