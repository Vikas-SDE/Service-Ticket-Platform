package com.sts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dto.request.RegisterRequest;
import com.sts.dto.response.UserResponse;
import com.sts.entity.User;
import com.sts.repository.UserRepository;
import com.sts.service.impl.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setName(request.name());
        user.setPhone(request.phone());
        user.setDepartment(request.department());
        user.setRole(request.role());

        User saved = userRepository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getEmail(),
                saved.getName(),
                saved.getPhone(),
                saved.getDepartment(),
                saved.getRole()
        );
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getName(),
                        user.getPhone(),
                        user.getDepartment(),
                        user.getRole()))
                .collect(Collectors.toList());
    }
}
