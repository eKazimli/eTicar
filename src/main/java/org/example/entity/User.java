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
    @Column(nullable = false, unique = true)
    String username;

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false)
    String password;

    @Column(nullable = false, length = 7)
    String fin;

    @Column(nullable = false, length = 10)
    String phone;

    @Email
    String email;

    Boolean admin = false;

    LocalDate birthDate;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isActive = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "balance_id", referencedColumnName = "id")
    UserBalance balance;


}
