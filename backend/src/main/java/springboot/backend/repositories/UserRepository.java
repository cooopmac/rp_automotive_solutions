package springboot.backend.repositories;

import org.springframework.data.repository.ListCrudRepository;
import springboot.backend.models.Users;

public interface UserRepository extends ListCrudRepository<Users, Integer> {

    
}
