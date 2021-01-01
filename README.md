# 構成

## DynamoDb-local

dockerコンテナで起動。

## table-creator

DynamoDBのテーブルを作成するコンテナ。

## spring-boot アプリケーション

`mvn`コマンドで起動。 dockerコンテナ化はしていない。

# アプリケーションの起動

## 事前準備

```shell
$ export AWS_DEFAULT_REGION=ap-northeast \
  && export AWS_ACCESS_KEY_ID=dammy-access-key \
  && export AWS_SECRET_ACCESS_KEY=dammy-secret-key
```

## 起動

```shell
$ docker-compose up --build

$ ./mvnw spring-boot:run
```