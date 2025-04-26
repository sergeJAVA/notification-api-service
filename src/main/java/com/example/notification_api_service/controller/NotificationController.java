package com.example.notification_api_service.controller;

import com.example.notification_api_service.model.Notification;
import com.example.notification_api_service.model.NotificationRequest;
import com.example.notification_api_service.model.NotificationResponse;
import com.example.notification_api_service.service.NotificationService;
import com.example.notification_api_service.service.feign.NotificationProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationProcessorService processorService;


    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(@RequestBody NotificationRequest request) {
        return ResponseEntity.ok(notificationService.sendNotification(request));
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable String notificationId) {
        return ResponseEntity.ok(processorService.getNotificationById(notificationId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(
            @PathVariable String userId,
            @RequestParam(defaultValue = "50") int limit) {
        List<Notification> notifications = processorService.getNotificationsByUserId(userId);
        return ResponseEntity.ok(notifications.stream().limit(limit).toList());
    }
}
