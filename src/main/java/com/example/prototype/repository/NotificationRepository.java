package com.example.prototype.repository;

import com.example.prototype.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class NotificationRepository {

    private final DynamoDbTable<Notification> table;

    @Autowired
    public NotificationRepository(DynamoDbEnhancedClient dynamoDbClient) {
        this.table = dynamoDbClient.table("Notifications", TableSchema.fromBean(Notification.class));  // Notificationsテーブルをセット
    }

    public void put(Notification notification) {
        table.putItem(notification);
    }

}
