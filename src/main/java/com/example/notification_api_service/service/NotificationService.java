package com.example.notification_api_service.service;

import com.example.notification_api_service.model.NotificationRequest;
import com.example.notification_api_service.model.NotificationResponse;

public interface NotificationService {
    NotificationResponse sendNotification(NotificationRequest request);
}
