package com.example.prototype.controller;

import com.example.prototype.domain.Notification;
import com.example.prototype.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/register")
    public Notification register() {
        Notification notification = new Notification("userId", "date", "yearToDay", "hourToSecond");
        notificationService.putNotification(notification);

        return notification;
    }

}
