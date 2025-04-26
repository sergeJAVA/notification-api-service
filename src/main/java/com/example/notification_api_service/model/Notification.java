package com.example.notification_api_service.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Notification {
    private String id;
    private String userId;
    private String type; // LIKE, COMMENT
    private String content;
    private String postId;
    private String status; // PENDING, SENT, FAILED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
