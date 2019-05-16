package shop.repos;

import org.springframework.data.repository.CrudRepository;
import shop.entity.Status;

public interface StatusRepo extends CrudRepository<Status,Long> {
}
