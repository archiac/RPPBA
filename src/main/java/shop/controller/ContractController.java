package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.entity.Contract;
import shop.entity.Product;
import shop.repos.ContractRepo;
import shop.service.ProductService;
import shop.service.ContractService;

import java.util.Map;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private ContractService contractService;

    @GetMapping
    public String itemList( Map<String,Object> model){
        Iterable<Product> items= productService.loadAllItems();
        model.put("items",items);
        return "itemList";
    }

    @GetMapping("{product}")
    public String userEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("item", product);
        return "orderAdd";
    }

    @GetMapping("list")
    public String orderList( Map<String,Object> model){
        Iterable<Contract> contracts= contractService.loadAllContracts();
        model.put("contracts",contracts);
        return "contractList";
    }
    @GetMapping("addOrder")
    public String phone(){
        return "orderAdd";
    }

    @PostMapping("orderAddOrd")
    public String addPhone(@RequestParam String _model, @RequestParam String _description, @RequestParam double _price,
            @RequestParam int _qty, @RequestParam String _username,@RequestParam String _address, @RequestParam String typePayment,
                           Map<String,Object> model){
        int _amount=_qty*(int)_price;
        boolean active=true;
        //Contract contract=new Contract(_username,_model,_description,_qty,_amount,_address, typePayment,active);
        //contractRepo.save(contract);
        return "redirect:/item";
    }

    @PostMapping("addSale")
    public String addSale(@RequestParam("orderId") Contract contract){
       // contract.setActive(false);
        contractRepo.save(contract);
        return "redirect:/order/list";
    }
}
