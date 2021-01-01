package com.example.prototype.service;

import com.example.prototype.domain.Notification;
import com.example.prototype.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void putNotification(Notification notification) {
        notificationRepository.put(notification);
    }

    // 今回は使用していません。無視して頂いて大丈夫です。
    public List<Notification> findByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }

}
