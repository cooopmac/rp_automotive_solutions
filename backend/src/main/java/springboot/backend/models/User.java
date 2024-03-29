package springboot.backend.models;

import java.time.LocalDateTime;

public record User(
    Integer id,
    String email,
    String password,
    LocalDateTime createdAt,
    String shopName,
    String address,
    String phoneNumber,
    String etransferEmail,
    String shopOwnerName,
    Float labourRate,
    String bestAutoPartSupplier
) {
}