package springboot.backend.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import springboot.backend.models.Users;

public interface UserRepository extends ListCrudRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
