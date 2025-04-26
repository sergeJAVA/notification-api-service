package com.example.notification_api_service.service.feign;

import com.example.notification_api_service.model.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "comments-api", url = "${feign..url}")
public interface NotificationProcessorService {
    @GetMapping("/userId/{userId}")
    List<Notification> getNotificationsByUserId(@PathVariable String userId);
    @GetMapping("/id/{notificationId}")
    Notification getNotificationById(@PathVariable String notificationId);
}
