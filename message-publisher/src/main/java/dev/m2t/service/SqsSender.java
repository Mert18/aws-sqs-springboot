package dev.m2t.service;

import dev.m2t.model.SqsMessage;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsSender {

    private final SqsTemplate sqsTemplate;

    public SqsSender(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public SendResult<String> sendMessage(SqsMessage message) {
        return sqsTemplate.send(sqsSendOptions -> {
            sqsSendOptions
                    .queue("springb-queue")
                    .payload(message.getMessage());
        });
    }
}
