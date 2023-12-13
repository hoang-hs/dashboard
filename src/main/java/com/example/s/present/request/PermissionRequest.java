package com.example.s.present.request;

import com.example.s.core.domain.Permission;
import com.example.s.core.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PermissionRequest {
    @NotBlank
    String userId;
    @NotBlank
    String teamId;
    @NotBlank
    Role role;

    public Permission ToDomain() {
        Permission permission = new Permission();
        permission.setRole(this.getRole());
        return permission;
    }
}
