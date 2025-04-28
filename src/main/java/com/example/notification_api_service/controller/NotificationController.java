package com.example.notification_api_service.controller;

import com.example.notification_api_service.model.Notification;
import com.example.notification_api_service.model.NotificationRequest;
import com.example.notification_api_service.model.NotificationResponse;
import com.example.notification_api_service.service.NotificationService;
import com.example.notification_api_service.service.feign.NotificationProcessorService;
import com.example.notification_api_service.service.security.JwtService;
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
    private final JwtService jwtService;


    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(@RequestBody NotificationRequest request) {
        return ResponseEntity.ok(notificationService.sendNotification(request));
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable String notificationId) {
        return ResponseEntity.ok(processorService.getNotificationById(notificationId));
    }

    @GetMapping("/user/notifications")
    public ResponseEntity<List<Notification>> getUserNotifications(
            @CookieValue("token") String token,
            @RequestParam(defaultValue = "50") int limit) {
        String userId = jwtService.getUserIdFromToken(token).toString();
        List<Notification> notifications = processorService.getNotificationsByUserId(userId);
        return ResponseEntity.ok(notifications.stream().limit(limit).toList());
    }

    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<String> delete(@PathVariable String notificationId) {
        return processorService.deleteNotification(notificationId);
    }

}
