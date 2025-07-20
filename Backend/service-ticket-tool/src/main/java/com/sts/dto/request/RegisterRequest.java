package com.sts.dto.request;

import com.sts.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("deprecation")
public record RegisterRequest(
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    String password,

    @NotBlank(message = "Name is required")
    String name,

    @NotBlank(message = "Phone is required")
    String phone,

    String department,
    UserRole role
) {}
