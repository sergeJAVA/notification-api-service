package com.example.notification_api_service.service;

import com.example.notification_api_service.model.Notification;
import com.example.notification_api_service.model.NotificationRequest;
import com.example.notification_api_service.model.NotificationResponse;

import java.util.List;

public interface NotificationService {
    NotificationResponse sendNotification(NotificationRequest request);
    Notification getNotification(String notificationId);
    List<Notification> getUserNotifications(String userId);
}
