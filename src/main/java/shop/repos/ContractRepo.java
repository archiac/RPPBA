package shop.repos;

import org.springframework.data.repository.CrudRepository;
import shop.entity.Contract;

import java.util.List;

public interface ContractRepo extends CrudRepository<Contract,Long> {
   // List<Contract> findByActive(boolean active);
}
