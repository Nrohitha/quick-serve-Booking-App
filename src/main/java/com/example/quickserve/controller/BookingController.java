package com.example.quickserve.controller;

import com.example.quickserve.dto.DTOs.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> create(@RequestBody BookingRequest req) {

        return ResponseEntity.ok(
                ApiResponse.ok("Booking created", Map.of("id", "QS-001"))
        );
    }
}