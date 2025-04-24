package com.example.notification_api_service.service;

import com.example.notification_api_service.model.Notification;
import com.example.notification_api_service.model.NotificationEvent;
import com.example.notification_api_service.model.NotificationRequest;
import com.example.notification_api_service.model.NotificationResponse;
import com.example.notification_api_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{
    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;
    private final NotificationRepository repository;
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

        Notification notification = Notification.builder()
                .id(notificationId)
                .userId(request.getUserId())
                .type(request.getType())
                .content(request.getContent())
                .postId(request.getPostId())
                .status("PENDING")
                .build();

        repository.save(notification);
        kafkaTemplate.send("notifications-topic", notificationId, event);
        return new NotificationResponse(notificationId, "ACCEPTED");
    }

    public Notification getNotification(String notificationId) {
        return repository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found: " + notificationId));
    }

    public List<Notification> getUserNotifications(String userId) {
        return repository.findByUserId(userId);
    }
}
