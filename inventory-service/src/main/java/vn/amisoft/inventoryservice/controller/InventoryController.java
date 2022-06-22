package vn.amisoft.inventoryservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.amisoft.inventoryservice.dto.InventoryResponse;
import vn.amisoft.inventoryservice.model.Inventory;
import vn.amisoft.inventoryservice.service.InventoryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/inventory")
public class InventoryController {
    public final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes){

        return inventoryService.isInStock(skuCodes);

    }
}
