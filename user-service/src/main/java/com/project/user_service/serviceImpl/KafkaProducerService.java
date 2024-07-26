package com.project.user_service.serviceImpl;

import com.event_module.model.UserVerifiedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, UserVerifiedEvent> kafkaTemplate;

    public void sendMessage(String topic, UserVerifiedEvent event) {
        kafkaTemplate.send(topic, event);
    }
}