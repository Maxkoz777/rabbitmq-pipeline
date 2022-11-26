package com.example.rabbitmqconsumer.consumer;

import com.example.rabbitmqconsumer.service.SupremeCourt;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class QueueConsumer {

    private static final String HELLO_MESSAGE = "Hello message!";
    private final SupremeCourt supremeCourt;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) {
        log.info("Message {}", fileBody);
        if (!fileBody.equals(HELLO_MESSAGE)) {
            supremeCourt.finalDecision(getMessageInfo(fileBody));
        }
    }

    private String getMessageInfo(String message) {
        List<String> words = Arrays.stream(message.split(" ")).toList();
        int size = words.size();
        String messageInfo = words.get(size - 3) + " ";
        messageInfo += words.get(size - 2) + " " + words.get(size - 1);
        return messageInfo;
    }
}
