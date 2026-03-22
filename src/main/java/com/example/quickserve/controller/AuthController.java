package com.example.quickserve.controller;

import com.example.quickserve.dto.DTOs.*;
import com.example.quickserve.model.User;
import com.example.quickserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:5500","http://127.0.0.1:5500","http://localhost:3000"})
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register/customer")
    public ResponseEntity<ApiResponse<String>> registerCustomer(@RequestBody RegisterRequest req){
        System.out.println("Saving user:" + req.getEmail());

        User user = User.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .password(req.getPassword())
                .role(User.Role.CUSTOMER)
                .build();

        userRepository.save(user);

        return ResponseEntity.ok(ApiResponse.ok("User saved", null));
    }

    @PostMapping("/register/provider")
    public ResponseEntity<ApiResponse<String>> registerProvider(@RequestBody RegisterRequest req) {
        return ResponseEntity.ok(ApiResponse.ok("Provider registered successfully. Pending verification.", null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody LoginRequest req) {

        Optional<User> userOpt = userRepository.findByEmail(req.getEmail());

        if (userOpt.isEmpty()) {
            return ResponseEntity.ok(ApiResponse.ok("User not found", null));
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.ok(ApiResponse.ok("Invalid password", null));
        }

        AuthResponse resp = new AuthResponse();
        resp.setToken("demo-jwt-token");
        resp.setRole(user.getRole().toString());
        resp.setName(user.getFirstName());
        resp.setEmail(user.getEmail());

        return ResponseEntity.ok(
                ApiResponse.ok("Login success", resp)
        );
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<ApiResponse<String>> verifyOtp(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(ApiResponse.ok("OTP verified successfully", null));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<ApiResponse<String>> forgotPassword(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(ApiResponse.ok("Reset link sent to " + body.get("email"), null));
    }
}