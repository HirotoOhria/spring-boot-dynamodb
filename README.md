# 構成

### DynamoDb-local

dockerコンテナで起動。

### table-creator

DynamoDBのテーブルを作成するコンテナ。

### spring-boot アプリケーション

`mvn`コマンドで起動。 dockerコンテナ化はしていない。

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

# シェルからDynamoDB-localにアクセスできることの確認

```shell
$ aws dynamodb list-tables --endpoint http://localhost:8000 
{
    "TableNames": [
        "Notifications"
    ]
}

$ aws dynamodb describe-table --table-name Notifications --endpoint http://localhost:8000
{
    "Table": {
        "AttributeDefinitions": [
            {
                "AttributeName": "userId",
                "AttributeType": "S"
            }
        ],
        "TableName": "Notifications",
        "KeySchema": [
            {
                "AttributeName": "userId",
                "KeyType": "HASH"
            }
        ],
        "TableStatus": "ACTIVE",
        "CreationDateTime": "2021-01-01T12:05:32.727000+09:00",
        "ProvisionedThroughput": {
            "LastIncreaseDateTime": "1970-01-01T09:00:00+09:00",
            "LastDecreaseDateTime": "1970-01-01T09:00:00+09:00",
            "NumberOfDecreasesToday": 0,
            "ReadCapacityUnits": 0,
            "WriteCapacityUnits": 0
        },
        "TableSizeBytes": 0,
        "ItemCount": 0,
        "TableArn": "arn:aws:dynamodb:ddblocal:000000000000:table/Notifications",
        "BillingModeSummary": {
            "BillingMode": "PAY_PER_REQUEST",
            "LastUpdateToPayPerRequestDateTime": "2021-01-01T12:05:32.727000+09:00"
        }
    }
}

```