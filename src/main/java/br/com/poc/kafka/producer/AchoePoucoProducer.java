package br.com.poc.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AchoePoucoProducer {

    private final String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public AchoePoucoProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String text) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), text).addCallback(
                success -> System.out.println("Deu bom!!!"),
                failure -> System.out.println("Deu ruim: " + failure.getCause())
        );
    }

}
