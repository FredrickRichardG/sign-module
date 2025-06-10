package com.healthcare.vitalsigns.config;

import com.healthcare.vitalsigns.entity.AuditPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class KafkaAuditPublisher {
    private final KafkaTemplate<String, AuditPayload> kafkaTemplate;

    @Value("${audit.kafka.topic:entity.audit}")
    private String auditTopic;

    public KafkaAuditPublisher(KafkaTemplate<String, AuditPayload> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public <T> void publish(String entityName, String entityId, String action, T oldVal, T newVal, String changedBy) {
        AuditPayload payload = new AuditPayload();
        payload.setEntityName(entityName);
        payload.setEntityId(entityId);
        payload.setAction(action);
        payload.setOldValue(oldVal);
        payload.setNewValue(newVal);
        payload.setChangedBy(changedBy);
        payload.setTimestamp(LocalDateTime.now());

        kafkaTemplate.send(auditTopic, entityId, payload);
    }
}
