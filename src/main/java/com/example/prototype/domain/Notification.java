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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDbAttribute(value = "date")
    public String getData() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDbAttribute(value = "yearToDay")
    public String getYearToDay() {
        return yearToDay;
    }

    public void setYearToDay(String yearToDay) {
        this.yearToDay = yearToDay;
    }

    @DynamoDbAttribute(value = "hourToSecond")
    public String getHourToSecond() {
        return hourToSecond;
    }
    
    public void setHourToSecond(String hourToSecond) {
        this.hourToSecond = hourToSecond;
    }
}
