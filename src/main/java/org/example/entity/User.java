package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false, unique = true, length = 16)
    String username;

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false, length = 10)
    String password;

    @Column(nullable = false, length = 10)
    String phone;

    @Email
    String email;

    Double balance = 0.0;

    LocalDate birthDate;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isActive = true;
}
