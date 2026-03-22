package com.example.quickserve.controller;
import com.example.quickserve.dto.DTOs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private List<Map<String, Object>> bookings = new ArrayList<>();

    @PostMapping
    public ResponseEntity<DTOs.ApiResponse<Map<String, Object>>> create(@RequestBody DTOs.BookingRequest req) {

        Map<String, Object> booking = new HashMap<>();
        booking.put("id", "QS-" + (bookings.size() + 1));
        booking.put("email", req.getEmail());
        booking.put("service", req.getService());
        booking.put("status", "Booked");

        bookings.add(booking);

        return ResponseEntity.ok(
                DTOs.ApiResponse.ok("Booking created", booking)
        );
    }

    // 🔥 ADD THIS (IMPORTANT)
    @GetMapping("/user/{email}")
    public ResponseEntity<DTOs.ApiResponse<List<Map<String, Object>>>> getUserBookings(@PathVariable String email) {

        List<Map<String, Object>> userBookings = bookings.stream()
                .filter(b -> email.equals(b.get("email")))
                .toList();

        return ResponseEntity.ok(
                DTOs.ApiResponse.ok("Bookings fetched", userBookings)
        );
    }
}