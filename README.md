# リンク

### 開発者ガイド

Import先も省略せずに書いてある。

- [Map items in DynamoDB tables](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/examples-dynamodb-enhanced.html)

### GitHub

一通りのコードの流れが書いてあるのでおすすめ。

- [dynamodb-enhanced](https://github.com/aws/aws-sdk-java-v2/tree/master/services-custom/dynamodb-enhanced)

### JavaDoc

- [DynamoDbEnhancedClient](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/enhanced/dynamodb/DynamoDbEnhancedClient.html)
- [annotations](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/enhanced/dynamodb/mapper/annotations/package-summary.html)
- [TableSchema](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/enhanced/dynamodb/TableSchema.html)
- [DynamoDbTable](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/enhanced/dynamodb/DynamoDbTable.html)
- [StaticAttributeTags](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/enhanced/dynamodb/mapper/StaticAttributeTags.html)

# アプリケーションの起動

### 事前準備

```shell
$ export AWS_DEFAULT_REGION=ap-northeast \
  && export AWS_ACCESS_KEY_ID=dammy-access-key \
  && export AWS_SECRET_ACCESS_KEY=dammy-secret-key
```

### 起動

```shell
$ docker-compose up --build

$ ./mvnw spring-boot:run

```

### アクセス

以下のエンドポイントにアクセスすると、テーブルにアイテムが追加される。

- http://localhost:8080/notification/create
