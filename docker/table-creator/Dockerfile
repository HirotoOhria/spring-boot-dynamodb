FROM alpine:3.12

ENV ENTRYKIT_VERSION 0.4.0

RUN apk --update add \
       openssl \
  && rm -rf /var/cache/apk/* \
  && wget https://github.com/progrium/entrykit/releases/download/v${ENTRYKIT_VERSION}/entrykit_${ENTRYKIT_VERSION}_Linux_x86_64.tgz \
  && tar -xvzf entrykit_${ENTRYKIT_VERSION}_Linux_x86_64.tgz \
  && rm entrykit_${ENTRYKIT_VERSION}_Linux_x86_64.tgz \
  && mv entrykit /bin/entrykit \
  && chmod +x /bin/entrykit \
  && entrykit --symlink

RUN apk add --no-cache \
        python3 \
        py3-pip \
    && pip3 install --upgrade pip \
    && pip3 install \
        awscli \
    && rm -rf /var/cache/apk/*

COPY docker/table-creator/notificationsTableRequest.json notifications.json

ENTRYPOINT [ \
    "prehook", "aws dynamodb create-table --cli-input-json file://notifications.json --endpoint-url http://dynamodb-local:8000", "--" \
]
