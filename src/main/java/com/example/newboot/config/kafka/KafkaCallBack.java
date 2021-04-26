package com.example.newboot.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaCallBack implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e == null) {
            log.info("Kafka push traninfo succ: {}", recordMetadata);
        } else {
            log.error("Kafka push traninfo fail: {}", e.getMessage(), e);
        }
    }
}
