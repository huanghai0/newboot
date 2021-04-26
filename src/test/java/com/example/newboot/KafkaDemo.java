package com.example.newboot;


import com.example.newboot.config.kafka.KafkaCallBack;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaDemo {

    @Autowired
    public KafkaProducer<String, String> producer;

    @Autowired
    public KafkaCallBack callBack;


    @Test
    public void kafkaProducerTest() {
        producer.send(new ProducerRecord("newboot", "aabbccddee"), callBack);
    }

}
