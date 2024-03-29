package springboot.backend.repositories;

import org.springframework.stereotype.Repository;
import springboot.backend.models.User;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Repository
public class UserCollectionRepository {

    private final List<User> userList = new ArrayList<>();

    public UserCollectionRepository() {
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public Optional<User> findById(Integer id) {
        return userList.stream().filter(user -> user.id().equals(id)).findFirst();
    }

    public void createUser(User user) {
        userList.add(user);
    }

    public void updateUser(User user) {
        userList.removeIf(u -> u.id().equals(user.id()));
        userList.add(user);
    }

    public boolean existsById(Integer id) {
        return userList.stream().anyMatch(user -> user.id().equals(id));
    }

    public void deleteUser(Integer id) {
        userList.removeIf(user -> user.id().equals(id));
    }

    @PostConstruct
    public void init() {
        User user1 = new User(1,
                "user1@test.ca",
                "pwd",
                LocalDateTime.now(),
                "user1 shopName",
                "123 Main St",
                "123-456-7890",
                "etransferemail@test.ca",
                "user1 shopOwnerName",
                100.0f,
                "user1 bestAutoPartSupplier");

        userList.add(user1);
    }

}