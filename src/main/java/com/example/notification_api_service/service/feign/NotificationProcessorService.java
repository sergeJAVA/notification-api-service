package com.example.notification_api_service.service.feign;

import com.example.notification_api_service.model.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notification-processor-service", url = "${feign.url}")
public interface NotificationProcessorService {
    @GetMapping("/userId/{userId}")
    List<Notification> getNotificationsByUserId(@PathVariable String userId);
    @GetMapping("/id/{notificationId}")
    Notification getNotificationById(@PathVariable String notificationId);
    @DeleteMapping("/delete/{notificationId}")
    ResponseEntity<String> deleteNotification(@PathVariable String notificationId);
}
