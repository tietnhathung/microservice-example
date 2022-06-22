package vn.amisoft.inventoryservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.amisoft.inventoryservice.service.InventoryService;

@RestController
@AllArgsConstructor
@RequestMapping("api/Inventory")
public class InventoryController {
    public final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable("sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
