package com.example.prototype.repository;

import com.example.prototype.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags.primaryPartitionKey;
import static software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags.primarySortKey;

@Repository
public class NotificationRepository {

    private final DynamoDbTable<Notification> table;

    @Autowired
    public NotificationRepository(DynamoDbEnhancedClient dynamoDbClient) {
        TableSchema<Notification> schema = TableSchema.builder(Notification.class)
                                                      .newItemSupplier(Notification::new)
                                                      .addAttribute(String.class, attr -> attr.name("user_id")
                                                                                              .getter(Notification::getUserid)
                                                                                              .setter(Notification::setUserId)
                                                                                              .tags(primaryPartitionKey()))
                                                      .addAttribute(String.class, attr -> attr.name("date")
                                                                                              .getter(Notification::getData)
                                                                                              .setter(Notification::setDate)
                                                                                              .tags(primarySortKey()))
                                                      .addAttribute(String.class, attr -> attr.name("name")
                                                                                              .getter(Notification::getName)
                                                                                              .setter(Notification::setName))
                                                      .build();

        this.table = dynamoDbClient.table("notifications", schema);
    }

    public void put(Notification notification) {
        table.putItem(notification);
    }

}
