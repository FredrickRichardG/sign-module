package com.healthcare.vitalsigns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vital_signs")
@Getter
@Setter
public class VitalSigns extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private String patientId;

    @Column(name = "pulse")
    private Integer pulse;

    @Column(name = "systolic_bp")
    private Integer systolicBP;

    @Column(name = "diastolic_bp")
    private Integer diastolicBP;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "respirations")
    private Integer respirations;

    @Column(name = "blood_sugar")
    private Double bloodSugar;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "spo2_saturation")
    private Integer spo2Saturation;

    @Column(name = "pt_inr")
    private Double ptInr;

    @Column(name = "notes")
    private String notes;
} 