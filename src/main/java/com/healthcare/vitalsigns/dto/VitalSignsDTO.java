package com.healthcare.vitalsigns.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class VitalSignsDTO {
    private Long id;

    @NotBlank(message = "Patient ID is required")
    private String patientId;

    @Min(value = 0, message = "Pulse must be greater than or equal to 0")
    @Max(value = 300, message = "Pulse must be less than or equal to 300")
    private Integer pulse;

    @Min(value = 0, message = "Systolic BP must be greater than or equal to 0")
    @Max(value = 300, message = "Systolic BP must be less than or equal to 300")
    private Integer systolicBP;

    @Min(value = 0, message = "Diastolic BP must be greater than or equal to 0")
    @Max(value = 200, message = "Diastolic BP must be less than or equal to 200")
    private Integer diastolicBP;

    @DecimalMin(value = "30.0", message = "Temperature must be greater than or equal to 30.0")
    @DecimalMax(value = "45.0", message = "Temperature must be less than or equal to 45.0")
    private Double temperature;

    @Min(value = 0, message = "Respirations must be greater than or equal to 0")
    @Max(value = 100, message = "Respirations must be less than or equal to 100")
    private Integer respirations;

    @DecimalMin(value = "0.0", message = "Blood sugar must be greater than or equal to 0.0")
    @DecimalMax(value = "1000.0", message = "Blood sugar must be less than or equal to 1000.0")
    private Double bloodSugar;

    @DecimalMin(value = "0.0", message = "Weight must be greater than or equal to 0.0")
    @DecimalMax(value = "500.0", message = "Weight must be less than or equal to 500.0")
    private Double weight;

    @DecimalMin(value = "0.0", message = "Height must be greater than or equal to 0.0")
    @DecimalMax(value = "300.0", message = "Height must be less than or equal to 300.0")
    private Double height;

    @Min(value = 0, message = "SPO2 saturation must be greater than or equal to 0")
    @Max(value = 100, message = "SPO2 saturation must be less than or equal to 100")
    private Integer spo2Saturation;

    @DecimalMin(value = "0.0", message = "PT/INR must be greater than or equal to 0.0")
    @DecimalMax(value = "20.0", message = "PT/INR must be less than or equal to 20.0")
    private Double ptInr;

    private String notes;
} 