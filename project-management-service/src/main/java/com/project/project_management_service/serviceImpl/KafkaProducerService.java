package com.project.project_management_service.serviceImpl;

import com.event_module.model.TaskDetailsEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, TaskDetailsEvent> kafkaTemplate;

    public void sendProjectDetails(String topic, TaskDetailsEvent event) {
        kafkaTemplate.send(topic, event);
    }

}
