package br.com.poc.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

    private String topic;

    @Value("${spring.kafka.producer.log.retention.minutes}")
    private String retention_in_minutes;

    public KafkaConfiguration(@Value("${kafka.name}") String topic) {
        this.topic = topic;
    }

    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name(topic)
                .partitions(3)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, retention_in_minutes)
                .build();
    }

}
