package vn.amisoft.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.amisoft.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}
