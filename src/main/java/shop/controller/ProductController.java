package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.entity.Product;
import shop.repos.ProductRepo;
import shop.service.ProductService;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepo productRepo;

    @GetMapping
    public String productList( Map<String,Object> model){
        Iterable<Product> products= productService.loadAllItems();
        model.put("products",products);
        return "productList";
    }

    @GetMapping("{product}")
    public String userEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("item", product);
        return "itemEdi";
    }

    @PostMapping("delItem")
    public String delete(@RequestParam("id") Product product, Map<String, Object> model){
        productService.deleteItem(product);
        Iterable<Product> items = productService.loadAllItems();
        model.put("items", items);
        return "itemList";
    }

    @PostMapping("filter")
    public String filter(@RequestParam ("filter") String filter, Map<String, Object> model){
        //Iterable<Product> items= productRepo.findByName(filter);
        //model.put("items",items);
        return "itemList";
    }

    @GetMapping("addProduct")
    public String phone(){
        return "productAdd";
    }

    @PostMapping("productAddproduct")
    public String addProduct(@RequestParam String product_name,@RequestParam int count, @RequestParam int price, @RequestParam String unit) {
        Product product=new Product(unit,product_name,price,count);
        productRepo.save(product);
        return "redirect:/product";
    }

}
