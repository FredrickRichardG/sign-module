package com.healthcare.vitalsigns.config;

import com.healthcare.vitalsigns.entity.AuditPayload;
import com.healthcare.vitalsigns.entity.EntityAuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuditKafkaListener {

    private final MongoTemplate mongoTemplate;

    @KafkaListener(topics = "entity.audit", groupId = "audit-group")
    public void listen(AuditPayload payload) {
        EntityAuditLog auditLog = new EntityAuditLog();
        auditLog.setEntityName(payload.getEntityName());
        auditLog.setEntityId(payload.getEntityId());
        auditLog.setAction(payload.getAction());
        auditLog.setOldValue(payload.getOldValue());
        auditLog.setNewValue(payload.getNewValue());
        auditLog.setChangedBy(payload.getChangedBy());
        auditLog.setTimestamp(payload.getTimestamp());

        mongoTemplate.save(auditLog);
    }
}
