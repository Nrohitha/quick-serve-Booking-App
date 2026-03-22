package com.example.quickserve.dto;

import lombok.*;

public class DTOs {

    @Data
    public static class LoginRequest {
        private String email;
        private String password;
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    @Data
    public static class RegisterRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String password;
        private String businessName;
        private String role;
        private String serviceCategory;
        private int yearsExperience;
    }

    @Data
    public static class AuthResponse {
        private String token;
        private String role;
        private String name;
        private String email;
    }

    @Data
    public static class BookingRequest {
        private Long providerId;
        private String serviceName;
        private String service;
        private String email;
        private String bookingDate;
        private String bookingTime;
        private String address;
        private java.math.BigDecimal amount;
        public String getService() {
            return service;
        }

            public String getEmail() {
                return email;
            }

    }

    @Data
    public static class ApiResponse<T> {
        private boolean success;
        private String message;
        private T data;

        public ApiResponse(boolean success, String message, T data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        public static <T> ApiResponse<T> ok(String msg, T data) {
            return new ApiResponse<>(true, msg, data);
        }

        public static <T> ApiResponse<T> err(String msg) {
            return new ApiResponse<>(false, msg, null);
        }
    }
}