package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.Company;
import shop.repos.CompanyRepo;

import javax.transaction.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Transactional
    public Iterable<Company> loadAllCompany(){
        return companyRepo.findAll();
    }

    @Transactional
    public void deleteCompany(Company company){
        companyRepo.delete(company);
    }

    @Transactional
    public Company saveCompany(Company company){
        return companyRepo.save(company);
    }
}
