package springboot.backend.configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DataSource userData;

    public SecurityConfig(DataSource userData) {
        this.userData = userData;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(userData);
        
        // Custom query to fetch user details using email
        userDetailsManager.setUsersByUsernameQuery("select email as username, password, true as enabled from users where email = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select email as username, account_type as authority from users where email = ?");
        
        return userDetailsManager;
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Configure CSRF
            .csrf(csrf -> csrf
                .disable() // Disable CSRF protection
            )
            // Configure authorization
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/register", "/api/login").permitAll() // Permit access to these endpoints
                .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin(Customizer.withDefaults()); // Keep the default form login configuration

        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
