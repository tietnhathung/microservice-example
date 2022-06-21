package vn.amisoft.productservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.amisoft.productservice.dto.ProductRequest;
import vn.amisoft.productservice.dto.ProductResponse;
import vn.amisoft.productservice.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/product")
public class ProductController {
    private ProductService productService;

    @GetMapping
    public List<ProductResponse>  getAllProducts(){
        return productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.create(productRequest);
    }
}
