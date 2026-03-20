package com.example.quickserve.controller;

import com.example.quickserve.dto.DTOs.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<Map<String, Object>>> dashboard() {

        return ResponseEntity.ok(
                ApiResponse.ok("Admin dashboard", Map.of("users", 100))
        );
    }
}