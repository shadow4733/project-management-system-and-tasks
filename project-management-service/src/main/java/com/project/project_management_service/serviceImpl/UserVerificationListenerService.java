package com.project.project_management_service.serviceImpl;

import com.event_module.model.UserVerifiedEvent;
import com.project.project_management_service.model.VerifiedUser;
import com.project.project_management_service.repository.VerifiedUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserVerificationListenerService {

    private final VerifiedUserRepository verifiedUserRepository;

    @KafkaListener(topics = "user-verified-topic", groupId = "project-management-service")
    public void consumeUserVerifiedEvent(UserVerifiedEvent userVerifiedEvent) {
        VerifiedUser verifiedUser = new VerifiedUser();
        verifiedUser.setUserId(userVerifiedEvent.getUserId());
        verifiedUser.setUsername(userVerifiedEvent.getUsername());

        verifiedUserRepository.save(verifiedUser);
    }

}
