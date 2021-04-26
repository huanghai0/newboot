package com.example.newboot.config.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public KafkaProducer kafkaProducer(KafkaConsumerProperties kafkaConsumerProperties) {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerProperties.getKafkaBrokers());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "JsBank");
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, kafkaConsumerProperties.getCompressionType());
        props.put(ProducerConfig.RETRIES_CONFIG, kafkaConsumerProperties.getRetries());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return new KafkaProducer<String, String>(props);
    }
}
