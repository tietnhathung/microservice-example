package vn.amisoft.productservice.dto;

import lombok.Data;
import vn.amisoft.productservice.model.Product;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private String name;
    private String description;
    private BigDecimal price;

    public static ProductResponse fromProduct(Product product){
        ProductResponse response = new ProductResponse();
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setDescription(product.getDescription());
        return response;
    }
}
