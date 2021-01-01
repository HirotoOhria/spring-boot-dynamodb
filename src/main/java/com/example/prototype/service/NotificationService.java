package com.example.prototype.service;

import com.example.prototype.domain.Notification;
import com.example.prototype.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void putNotification(Notification notification) {
        notificationRepository.put(notification);
    }

}
