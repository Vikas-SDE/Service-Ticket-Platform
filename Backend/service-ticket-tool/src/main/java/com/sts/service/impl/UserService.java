package com.sts.service.impl;

import java.util.List;

import com.sts.dto.request.RegisterRequest;
import com.sts.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(RegisterRequest request);
    List<UserResponse> getAllUsers();
}
