package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.entity.Product;
import shop.repos.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public Iterable<Product> loadAllItems(){
        return productRepo.findAll();
    }


    @Transactional
    public void deleteItem(Product product){
        productRepo.delete(product);
    }

    @Transactional
    public Product saveProduct(Product product){
        return productRepo.save(product);
    }
}
