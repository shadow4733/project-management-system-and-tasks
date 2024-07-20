package com.project.user_service.serviceImpl;

import com.event_module.model.UserVerifiedEvent;
import com.project.user_service.dto.request.AuthenticationRequest;
import com.project.user_service.dto.request.UpdatePasswordRequest;
import com.project.user_service.dto.request.UserRequest;
import com.project.user_service.dto.response.AuthenticationResponse;
import com.project.user_service.dto.response.UpdatePasswordResponse;
import com.project.user_service.dto.response.UserResponse;
import com.project.user_service.exception.*;
import com.project.user_service.model.User;
import com.project.user_service.model.enums.Role;
import com.project.user_service.repository.UserRepository;
import com.project.user_service.service.UserService;
import com.project.user_service.serviceImpl.utils.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordValidator passwordValidator;
    private final PasswordEncoder passwordEncoder;
    private final EmailServiceImpl emailService;
    private final KafkaProducerService kafkaProducerService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        User user = new User();
        if (userRepository.existsByUsername(userRequest.username())){
            throw new UsernameAlreadyExistsException(userRequest.username());
        } else if (userRepository.existsByEmail(userRequest.email())){
            throw new EmailAlreadyExistsException(userRequest.email());
        } else if (!userRequest.password().equals(userRequest.passwordConfirm())){
            throw new PasswordMissmatchException();
        } else if (!passwordValidator.isPasswordValid(userRequest.password())){
            throw new WeakPasswordException(userRequest.password());
        }
        user.setUsername(userRequest.username());
        user.setEmail(userRequest.email());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setRole(Role.USER);
        user.setEmailVerified(false);
        user.setCratedAt(LocalDateTime.now());
        String emailToken = UUID.randomUUID().toString();
        user.setEmailToken(emailToken);
        emailService.sendEmailVerificationToken(user);

        userRepository.save(user);
        logger.info("User with username: " + user.getUsername() + " has been registered");
        return new UserResponse(
                user.getUserId(),
                user.getUsername()
        );
    }

    @Override
    public void confirmEmail(String token) {
        User user = userRepository.findByEmailToken(token);
        user.setEmailVerified(true);
        user.setEmailToken(null);

        UserVerifiedEvent event = new UserVerifiedEvent();
        event.setUserId(user.getUserId());
        event.setUsername(user.getUsername());
        kafkaProducerService.sendMessage("user-verified-topic", event);

        userRepository.save(user);
        logger.info("User email confirmed");
    }

    @Override
    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        User user = userRepository.findByUsername(authenticationRequest.username());
        if (user == null){
            throw new UserDoesNotExistException();
        } else if (!passwordEncoder.matches(authenticationRequest.password(),user.getPassword())) {
            throw new PasswordIsIncorrectException();
        } else if (!user.isEmailVerified()){
            throw new EmailHasNotBeenConfirmedException();
        }

        logger.info("User authenticated");
        return new AuthenticationResponse(
              user.getUserId(),
                "successful"
        );
    }

    @Override
    public UpdatePasswordResponse updatePasswordById(UpdatePasswordRequest updatePasswordRequest) {
        return null;
    }

    @Override
    public void deleteUser(UUID userId) {
        if(!userRepository.existsById(userId)){
            throw new UserDoesNotExistException();
        }

        userRepository.deleteById(userId);
    }
}
