package com.example.notification_api_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotificationResponse {
    private String notificationId;
    private String status;
}
