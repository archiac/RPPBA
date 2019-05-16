package shop.repos;

import org.springframework.data.repository.CrudRepository;
import shop.entity.Product;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product,Long> {
   // List<Product> findByName(String name);
    //List<Product> findByNameContains(String name);
}
