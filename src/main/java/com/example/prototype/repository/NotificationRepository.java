package com.example.prototype.repository;

import com.example.prototype.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.List;
import java.util.stream.Collectors;

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

    // 今回は使用していません。無視して頂いて大丈夫です。
    public List<Notification> findByUserId(String userId) {
        Key partitionIsUserIdKey = Key.builder().partitionValue(userId).build();
        QueryConditional partitionEqualToUserIdConditional = QueryConditional.keyEqualTo(partitionIsUserIdKey);

        return table.query(partitionEqualToUserIdConditional)
                    .items()
                    .stream()
                    .collect(Collectors.toList());
    }

}
