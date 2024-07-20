package com.project.user_service.serviceImpl;

import com.event_module.model.UserVerifiedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, UserVerifiedEvent> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, UserVerifiedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, UserVerifiedEvent event) {
        kafkaTemplate.send(topic, event);
    }
}