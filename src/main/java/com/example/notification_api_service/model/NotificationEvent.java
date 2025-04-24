package com.example.notification_api_service.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NotificationEvent {
    private String notificationId;
    private String userId;
    private String type;
    private String content;
    private String postId;
}