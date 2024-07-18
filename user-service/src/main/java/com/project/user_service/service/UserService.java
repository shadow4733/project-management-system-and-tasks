package com.project.user_service.service;

import com.project.user_service.dto.request.AddUserToTheProjectRequest;
import com.project.user_service.dto.request.AuthenticationRequest;
import com.project.user_service.dto.request.UpdatePasswordRequest;
import com.project.user_service.dto.request.UserRequest;
import com.project.user_service.dto.response.AddUserToTheProjectResponse;
import com.project.user_service.dto.response.AuthenticationResponse;
import com.project.user_service.dto.response.UpdatePasswordResponse;
import com.project.user_service.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    void confirmEmail(String token);
    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);
    UpdatePasswordResponse updatePasswordById(UpdatePasswordRequest updatePasswordRequest);
    void deleteUser(UUID userId);
}
