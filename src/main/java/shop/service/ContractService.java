package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.entity.Contract;
import shop.repos.ContractRepo;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepo contractRepo;

    @Transactional
     public Iterable<Contract> loadAllContracts(){
        return contractRepo.findAll();
    }

//    @Transactional
//    public List<Contract> loadOrderByActive() {
//        return  contractRepo.findByActive(true);
//    }
}
