package org.example.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.SuperAdmin;
import org.example.entity.User;
import org.example.service.SuperAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/superAdmin")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SuperAdminController {

    SuperAdminService superAdminService;

    @PostMapping("/create")
    public ResponseEntity<?> createSuperAdmin(@RequestBody SuperAdmin superAdmin) {
        SuperAdmin superAdminSave = superAdminService.create(superAdmin);
        return ResponseEntity.ok(superAdminSave);
    }

    @PutMapping("/adminAuthority/{id}")
    public ResponseEntity<?> AdminAuthority(@PathVariable Long id) {
        superAdminService.adminAuthority(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/removeAdmin/{id}")
    public ResponseEntity<?> RemoveAdmin(@PathVariable Long id) {
        superAdminService.removeAdmin(id);
        return ResponseEntity.ok().build();
    }

}
