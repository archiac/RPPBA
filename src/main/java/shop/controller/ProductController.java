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
@RequestMapping("/item")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepo productRepo;

    @GetMapping
    public String itemList( Map<String,Object> model){
        Iterable<Product> items= productService.loadAllItems();
        model.put("items",items);
        return "itemList";
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

    @GetMapping("addPhone")
    public String phone(){
        return "itemAddPhone";
    }

    @GetMapping("addLaptop")
    public String laptop(){
        return "itemAddLaptop";
    }



    @PostMapping("itemAddPhone")
    public String addPhone(@RequestParam String name, @RequestParam String description,
                           @RequestParam double price, @RequestParam int qty,
                           @RequestParam String options, @RequestParam boolean isexist,
                           Map<String,Object> model){
       // Product product = new Product(name, description, price, isexist, qty, options, Collections.singleton(ItemType.PHONE));
      //  productRepo.save(product);
        return "redirect:/item";
    }

    @PostMapping("itemAddLaptop")
    public String addLaptop(@RequestParam String name, @RequestParam String description,
                           @RequestParam double price, @RequestParam int qty,
                           @RequestParam String options, @RequestParam boolean isexist,
                           Map<String,Object> model){

      //  Product product = new Product(name, description, price, isexist, qty, options, Collections.singleton(ItemType.LAPTOP));
       // productRepo.save(product);

        return "redirect:/item";
    }

    @PostMapping("filter")
    public String filter(@RequestParam ("filter") String filter, Map<String, Object> model){
        //Iterable<Product> items= productRepo.findByName(filter);
        //model.put("items",items);
        return "itemList";
    }
}
