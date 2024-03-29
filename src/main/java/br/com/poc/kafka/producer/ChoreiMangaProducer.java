package br.com.poc.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ChoreiMangaProducer {

    private final String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ChoreiMangaProducer(@Value("${spring.kafka.topic}") String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String text) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), text).addCallback(
                success -> System.out.println("Chupa essa manga!!!"),
                failure -> System.out.println("Deu ruim: " + failure.getCause())
        );
    }

}
