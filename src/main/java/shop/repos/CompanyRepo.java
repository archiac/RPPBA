package shop.repos;

import org.springframework.data.repository.CrudRepository;
import shop.entity.Company;

public interface CompanyRepo extends CrudRepository<Company,Long> {
}
