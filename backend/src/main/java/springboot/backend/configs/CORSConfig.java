package springboot.backend.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {  // Add @NonNull annotation here
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")  // Specify the origins allowed to access the server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Specify the methods allowed
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true)  // Indicates whether to allow sending credentials
                .maxAge(3600);  // Cache the preflight response for 1 hour
    }
}

