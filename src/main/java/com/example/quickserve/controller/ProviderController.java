package com.example.quickserve.controller;

import com.example.quickserve.dto.DTOs.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/providers")
@CrossOrigin(origins = "*")
public class ProviderController {

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Map<String, Object>>>> search(@RequestParam(required = false) String category) {

        List<Map<String, Object>> providers = List.of(
                Map.of("id", 1, "name", "Ramesh Kumar", "rating", 4.9),
                Map.of("id", 2, "name", "Sunita Patel", "rating", 4.8)
        );

        return ResponseEntity.ok(ApiResponse.ok("Providers fetched", providers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> get(@PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.ok("Provider fetched", Map.of("id", id, "name", "Ramesh Kumar"))
        );
    }
}
