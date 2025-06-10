package com.healthcare.vitalsigns.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AuditPayload {
    private String entityName;
    private String entityId;
    private String action; // CREATE, UPDATE, DELETE
    private Object oldValue;
    private Object newValue;
    private String changedBy;
    private LocalDateTime timestamp;
}
