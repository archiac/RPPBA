package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.Status;
import shop.repos.StatusRepo;

import javax.transaction.Transactional;

@Service
public class StatusService {

    @Autowired
    private StatusRepo statusRepo;

    @Transactional
    public Iterable<Status> loadAllStatus(){
        return statusRepo.findAll();
    }
}
