package com.example.prototype.controller;

import com.example.prototype.domain.Notification;
import com.example.prototype.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/create")
    public Notification create() {
        Notification notification = new Notification("userId", "date", "name");
        notificationService.putNotification(notification);

        return notification;
    }

}
