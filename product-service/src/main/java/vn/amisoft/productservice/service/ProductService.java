package vn.amisoft.productservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.amisoft.productservice.dto.ProductResponse;
import vn.amisoft.productservice.model.Product;
import vn.amisoft.productservice.repository.ProductRepository;
import vn.amisoft.productservice.dto.ProductRequest;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public void create(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        productRepository.save(product);
        log.info("Product is saved. Id={}",product.getId());
    }

    public List<ProductResponse> getAll() {
        List<Product> product = productRepository.findAll();
        return product.stream().map(ProductResponse::fromProduct).collect(Collectors.toList());
    }
}
