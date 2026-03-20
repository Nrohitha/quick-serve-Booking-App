package com.example.quickserve.controller;

import com.example.quickserve.dto.DTOs.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @PostMapping("/initiate")
    public ResponseEntity<ApiResponse<Map<String, Object>>> initiate(@RequestBody Map<String, Object> body) {

        return ResponseEntity.ok(
                ApiResponse.ok("Payment initiated", Map.of("status", "SUCCESS"))
        );
    }
}