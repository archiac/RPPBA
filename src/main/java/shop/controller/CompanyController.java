package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.entity.Company;
import shop.entity.Status;
import shop.repos.CompanyRepo;
import shop.repos.StatusRepo;
import shop.service.CompanyService;
import shop.service.StatusService;

import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping
    public String companyList( Map<String,Object> model){
        Iterable<Company> companies=companyService.loadAllCompany();
        model.put("companies",companies);
        return "companyList";
    }

    @GetMapping("addCompany")
    public String phone(Map<String,Object> model){
        Iterable<Status> statuses=statusService.loadAllStatus();
        model.put("statuses",statuses);
        return "companyAdd";
    }

    @PostMapping("companyAddCompany")
    public String addCompany( @RequestParam String company_name, @RequestParam String address, @RequestParam String company_phone, @RequestParam int credit_lim,
                            @RequestParam("choiceStatus") Status status_id, @RequestParam int current_debit){
        Company company=new Company(company_name,credit_lim,address,company_phone,current_debit,status_id);
        companyRepo.save(company);
        return "redirect:/company";
    }

    @PostMapping("delCompany")
    public String delete(@RequestParam("id") Company company, Map<String, Object> model){
        companyService.deleteCompany(company);
        return "redirect:/company";
    }

    @GetMapping("{company}")
    public String userEditForm(@PathVariable Company company, Map<String,Object> model) {
        Iterable<Status> statuses=statusService.loadAllStatus();
        model.put("statuses",statuses);
        model.put("company", company);
        return "companyEdi";
    }

    @PostMapping
    public String productSave(
            @RequestParam("address") String address, @RequestParam("phone") String phone, @RequestParam("credit") int  credit,
            @RequestParam("choiceStatus") Status status, @RequestParam("debit") int debit,
            @RequestParam("companyId") Company company
    ) {
        company.setAddress(address);
        company.setGetCompany_phone(phone);
        company.setCredit_lim(credit);
        company.setCurrent_debit(debit);
        company.setStatus(status);
        companyService.saveCompany(company);
        return "redirect:/company";
    }
}
