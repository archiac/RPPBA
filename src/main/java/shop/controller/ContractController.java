package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.entity.Company;
import shop.entity.Contract;
import shop.entity.Product;
import shop.entity.User;
import shop.repos.ContractRepo;
import shop.service.CompanyService;
import shop.service.ProductService;
import shop.service.ContractService;
import shop.service.UserService;

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

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String itemList( Map<String,Object> model){
        Iterable<Product> items= productService.loadAllItems();
        model.put("items",items);
        return "itemList";
    }

    @GetMapping("list")
    public String orderList( Map<String,Object> model){
        Iterable<Contract> contracts= contractService.loadAllContracts();
        model.put("contracts",contracts);
        return "contractList";
    }
    @GetMapping("addContract")
    public String phone(Map<String,Object> model){
        Iterable<Company> companies= companyService.loadAllCompany();
        Iterable<User> users=userService.loadAllUsers();
        Iterable<Product> products=productService.loadAllItems();
        model.put("products",products);
        model.put("users",users);
        model.put("companies",companies);
        return "contractAdd";
    }

    @PostMapping("contractAddContr")
    public String addPhone(@RequestParam("choiceCompany") Company company_id, @RequestParam("choiceUser") User user_id, @RequestParam String date_shipping,
                           @RequestParam String date_zak, @RequestParam("choiceDogovor") String type_dog,@RequestParam("choiceProduct") Product product,
                           @RequestParam("count_product") int count_product,
                           @RequestParam("choicePayment") String type_payment){
        product.setCount(product.getCount()-count_product);


        String status_dog="Не отгружен";
        double total_sum=product.getPrice()*count_product*(1-company_id.getStatus().getDiscount()/100);
        Contract contract=new Contract(date_zak,date_shipping,type_dog,total_sum,type_payment,status_dog,user_id,company_id);
        contractRepo.save(contract);
        return "redirect:/contract/list";
    }

    @PostMapping("addContractSale")
    public String addSale(@RequestParam("contractId") Contract contract){
        contract.setStatus_dog("Готовится к отгрузке");
        contractRepo.save(contract);
        return "redirect:/contract/list";
    }

    @PostMapping("addContractShipment")
    public String addShipment(@RequestParam("contrId") Contract contract){
        contract.setStatus_dog("Отгружен");
        contractRepo.save(contract);
        return "redirect:/contract/list";
    }

    @GetMapping("contractHistory")
    public String historyList( Map<String,Object> model) {
        Iterable<Contract> contracts = contractService.loadAllContracts();
        model.put("contracts", contracts);
        return "contractHistory";
    }

    @GetMapping("{contract}")
    public String changeDiscount(@PathVariable Contract contract, Model model) {
        model.addAttribute("contract", contract);
        return "changeDiscount";
    }

    @PostMapping("changeDisc")
    public String changeDisc(@RequestParam("contrId") Contract contract,@RequestParam("new_discount") double new_disc){
        double old_sum=contract.getTotal_sum()/(1-contract.getCompany().getStatus().getDiscount()/100);
        double new_sum=old_sum*(1-new_disc/100);
        contract.setTotal_sum(new_sum);
        contractRepo.save(contract);
        return "redirect:/contract/list";
    }

}
