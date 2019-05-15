package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.entity.Contract;
import shop.entity.Item;
import shop.repos.ContractRepo;
import shop.service.ItemService;
import shop.service.ContractService;

import java.util.Map;

@Controller
@RequestMapping("/contract")
@PreAuthorize("hasAuthority('ADMIN')")
public class ContractController {

    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ContractService contractService;

    @GetMapping
    public String itemList( Map<String,Object> model){
        Iterable<Item> items=itemService.loadAllItems();
        model.put("items",items);
        return "itemList";
    }

    @GetMapping("{item}")
    public String userEditForm(@PathVariable Item item, Model model) {
        model.addAttribute("item", item);
        return "orderAdd";
    }

    @GetMapping("list")
    public String orderList( Map<String,Object> model){
        Iterable<Contract> contracts= contractService.loadAllContracts();
        model.put("contracts",contracts);
        return "contractList";
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
