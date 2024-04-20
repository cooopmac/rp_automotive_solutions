package springboot.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import springboot.backend.models.Users;
import springboot.backend.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@RestController
public class AuthController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        // Encode the password
        String encodedPassword = passwordEncoder.encode(user.password());
        String accountType = user.account_type() == null ? "regular" : user.account_type();

        // Create a new user record with the encoded password. Pass null or appropriate values for fields as needed.
        Users newUser = new Users(
            null,
            user.email(),
            encodedPassword,
            accountType,
            LocalDateTime.now(),  // Set created_at to current time
            LocalDateTime.now(),  // Set updated_at to current time
            user.shop_name(),
            user.address(),
            user.phone_number(),
            user.etransfer_email(),
            user.shop_owner_name(),
            user.labour_rate(),
            user.bestauto_part_supplier()
        );

        // Save the new user to the repository
        Users savedUser = repository.save(newUser);

        // Return the created user and status code 201 CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}

