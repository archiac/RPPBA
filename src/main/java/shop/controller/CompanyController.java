package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.entity.Company;
import shop.service.CompanyService;

import java.util.Map;

@Controller
@RequestMapping("/company")
@PreAuthorize("hasAuthority('ADMIN')")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String companyList( Map<String,Object> model){
        Iterable<Company> companies=companyService.loadAllCompany();
        model.put("companies",companies);
        return "companyList";
    }
}
