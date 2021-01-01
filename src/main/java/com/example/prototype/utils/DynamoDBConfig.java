package com.example.prototype.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDBConfig {

    /**
     * デフォルトのクレデンシャル環境変数以外から、クレデンシャル情報を設定する方法としてコードを残しておきます。
     */
//    @Bean
//    public DynamoDbClient dynamoDbClient() {
//        AwsSessionCredentials awsCredentials = AwsSessionCredentials.create("dummyAccessKey", "dummySecretKey", "dummySessionToken");
//        return DynamoDbClient.builder()
//                             .region(Region.AP_NORTHEAST_1)
//                             .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
//                             .endpointOverride(URI.create("http://localhost:8000/"))
//                             .build();
//    }
    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                             .endpointOverride(URI.create("http://localhost:8000/"))  // dynamodbのendpointを設定
                             .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient() {
        return DynamoDbEnhancedClient.builder()
                                     .dynamoDbClient(dynamoDbClient())
                                     .build();
    }
}
