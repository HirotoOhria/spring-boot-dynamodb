package com.example.prototype.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private String userId;
    private String date;
    private String yearToDay;
    private String hourToSecond;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(value = "userId")
    public String getUserid() {
        return userId;
    }

    @DynamoDbAttribute(value = "date")
    public String getData() {
        return date;
    }

    @DynamoDbAttribute(value = "yearToDay")
    public String getYearToDay() {
        return yearToDay;
    }

    @DynamoDbAttribute(value = "hourToSecond")
    public String getHourToSecond() {
        return hourToSecond;
    }
}
