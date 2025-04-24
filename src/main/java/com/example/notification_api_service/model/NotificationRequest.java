package com.example.notification_api_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
    private String userId; // Кому отправить уведомление
    private String type; // LIKE, COMMENT
    private String content; // Текст уведомления
    private String postId;
}
