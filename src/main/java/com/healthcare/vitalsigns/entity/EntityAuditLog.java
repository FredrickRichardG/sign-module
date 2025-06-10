package com.healthcare.vitalsigns.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "entity_audit_logs")

public class EntityAuditLog {
    private String entityName;
    @Id
    private String id;
    private String entityId;
    private String action; // CREATE, UPDATE, DELETE
    private Object oldValue;
    private Object newValue;
    private String changedBy;
    private LocalDateTime timestamp;
}
