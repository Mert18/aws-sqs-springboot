package dev.m2t.service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class SqsReceiver {
    private static final Logger logger = LoggerFactory.getLogger(SqsReceiver.class);


    @SqsListener("springb-queue")
    public void queueListener(Message message) {
        logger.info("Message received from queue 'springb-queue': {}", message.getPayload());
    }
}
