package com.example.notification_api_service.service;

import com.example.notification_api_service.model.NotificationEvent;
import com.example.notification_api_service.model.NotificationRequest;
import com.example.notification_api_service.model.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{
    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;
    @Override
    public NotificationResponse sendNotification(NotificationRequest request) {

        String notificationId = UUID.randomUUID().toString();

        NotificationEvent event = NotificationEvent.builder()
                .notificationId(notificationId)
                .userId(request.getUserId())
                .type(request.getType())
                .content(request.getContent())
                .postId(request.getPostId())
                .build();
        kafkaTemplate.send("notifications-topic", notificationId, event);
        return new NotificationResponse(notificationId, "ACCEPTED");
    }

}
