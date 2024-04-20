package springboot.backend.controllers;

import springboot.backend.models.Users;
import springboot.backend.repositories.UserRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    // private final UserCollectionRepository repository;
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // make a request and see all users
    @GetMapping("")
    public List<Users> findAllUsers() {
        return repository.findAll();
    }

    // make a request and see a specific user
    @GetMapping("/{id}")
    public Users findUserById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @GetMapping("/by-email/{email}")
    public Users findUserByUsername(@PathVariable String email) {
        return repository.findByEmail(email)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    // mapping to update a user
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody Users user) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        repository.save(user);
    }

    // mapping to delete a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        repository.deleteById(id);
    }
}