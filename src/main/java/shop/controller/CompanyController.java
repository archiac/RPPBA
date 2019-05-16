package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.Company;
import shop.entity.Status;
import shop.repos.CompanyRepo;
import shop.repos.StatusRepo;
import shop.service.CompanyService;
import shop.service.StatusService;

import java.util.Map;

@Controller
@RequestMapping("/company")
@PreAuthorize("hasAuthority('ADMIN')")
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
}
