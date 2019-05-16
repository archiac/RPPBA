package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.Product;
import shop.repos.ProductRepo;
import shop.service.ProductService;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/")
    public String mainPage(Map<String, Object> model) {
        Iterable<Product> items = productService.loadAllItems();
        model.put("items", items);
        return "main";
    }

    @GetMapping("/main")
    public String getMainPage(Map<String, Object> model) {
        Iterable<Product> items = productService.loadAllItems();
        model.put("items", items);
        return "main";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/about")
    public String about(Map<String, Object> model) {
        return "aboutShop";
    }

    @PostMapping("filterMain")
    public String filter(@RequestParam("filterMain") String filter, Map<String, Object> model) {
        if (filter.isEmpty()){
            Iterable<Product> items = productService.loadAllItems();
            model.put("items", items);
            return "main";
        } else {
           // Iterable<Product> items = productRepo.findByNameContains(filter);
            //model.put("items", items);
            return "main";
        }
    }
}