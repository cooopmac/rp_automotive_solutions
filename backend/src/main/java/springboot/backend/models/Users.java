package springboot.backend.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Users(
    @Id
    Integer id,
    String email,
    String password,
    String account_type,
    LocalDateTime created_at,
    LocalDateTime updated_at,
    String shop_name,
    String address,
    String phone_number,
    String etransfer_email,
    String shop_owner_name,
    Float labour_rate,
    String bestauto_part_supplier
) {
}