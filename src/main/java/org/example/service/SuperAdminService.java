package org.example.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.SuperAdmin;
import org.example.entity.User;
import org.example.repository.SuperAdminRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SuperAdminService {

    SuperAdminRepository superAdminRepository;
    UserRepository userRepository;

    public SuperAdmin create(SuperAdmin superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

    public void adminAuthority(Long id) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        if (!user.getAdmin()) {
            user.setAdmin(true);
            userRepository.save(user);
        } else {
            throw new RuntimeException("This user already has admin rights");
        }
    }

    public void removeAdmin(Long id) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        if (user.getAdmin()) {
            user.setAdmin(false);
            userRepository.save(user);
        } else {
            throw new RuntimeException("He is not an admin anyway");
        }
    }

}
