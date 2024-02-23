package dev.m2t.controller;

import dev.m2t.model.SqsMessage;
import dev.m2t.service.SqsSender;
import io.awspring.cloud.sqs.operations.SendResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sqs")
public class SqsController {
    private final SqsSender sender;

    public SqsController(SqsSender sender) {
        this.sender = sender;
    }

    @PostMapping
    @RequestMapping("/send")
    public ResponseEntity<SendResult<String>> sendMessage(@RequestBody SqsMessage message) {
        return ResponseEntity.ok(sender.sendMessage(message));
    }
}
