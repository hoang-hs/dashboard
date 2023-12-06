package com.example.s.present.controller;

import com.example.s.core.domain.Permission;
import com.example.s.core.service.PermissionService;
import com.example.s.present.request.PermissionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController extends BaseController {
    private final PermissionService permissionService;

    @PostMapping("")
    Permission save(@RequestBody PermissionRequest req) {
        return permissionService.save(req);
    }

    @GetMapping("/{id}")
    Permission get(@PathVariable String id) {
        return permissionService.get(id);
    }

}
