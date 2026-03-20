package com.example.quickserve.controller;

import com.example.quickserve.dto.DTOs.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @GetMapping
    public ResponseEntity<ApiResponse<List<Map<String, Object>>>> all() {

        List<Map<String, Object>> cats = List.of(
                Map.of("id", 1, "name", "Plumbing"),
                Map.of("id", 2, "name", "Electrical"),
                Map.of("id", 3, "name", "Cleaning")
        );

        return ResponseEntity.ok(ApiResponse.ok("Categories fetched", cats));
    }
}