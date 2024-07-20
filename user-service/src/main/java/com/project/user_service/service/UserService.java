package com.project.user_service.service;

import com.project.user_service.dto.request.AuthenticationRequest;
import com.project.user_service.dto.request.UpdatePasswordRequest;
import com.project.user_service.dto.request.UserRequest;
import com.project.user_service.dto.response.AuthenticationResponse;
import com.project.user_service.dto.response.UpdatePasswordResponse;
import com.project.user_service.dto.response.UserResponse;

import java.util.UUID;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    void confirmEmail(String token);
    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);
    UpdatePasswordResponse updatePasswordById(UpdatePasswordRequest updatePasswordRequest);
    void deleteUser(UUID userId);
}
