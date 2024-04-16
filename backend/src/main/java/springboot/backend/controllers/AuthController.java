package springboot.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import springboot.backend.models.Users;
import springboot.backend.repositories.UserRepository;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/api/login")
    public String login() {
        return "Hello, Auth";
    }
    
        // mapping to create a new user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        // Encode the password
        String encodedPassword = passwordEncoder.encode(user.password());

        // Create a new user record with the encoded password. Pass null or appropriate values for fields as needed.
        Users newUser = new Users(
            null, // ID is null or not used, assuming your repository or database auto-generates it
            user.email(),
            encodedPassword,
            user.account_type(),
            user.created_at() != null ? user.created_at() : LocalDateTime.now(), // Assuming current time if not provided
            user.updated_at(),
            user.shop_name(),
            user.address(),
            user.phone_number(),
            user.etransfer_email(),
            user.shop_owner_name(),
            user.labour_rate(),
            user.bestauto_part_supplier()
        );

        // Save the new user to the repository and return the persisted user
        // Adjust this according to your repository's method to save and return the persisted user
        return repository.save(newUser);
    }
    
}
