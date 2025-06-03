package com.healthcare.vitalsigns.controller;

import com.healthcare.vitalsigns.dto.VitalSignsDTO;
import com.healthcare.vitalsigns.service.VitalSignsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vital-signs")
@RequiredArgsConstructor
@Tag(name = "Vital Signs", description = "Vital Signs management APIs")
public class VitalSignsController {

    private final VitalSignsService service;

    @PostMapping
    @Operation(summary = "Create new vital signs record")
    public ResponseEntity<VitalSignsDTO> create(@Valid @RequestBody VitalSignsDTO vitalSignsDTO) {
        return new ResponseEntity<>(service.create(vitalSignsDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing vital signs record")
    public ResponseEntity<VitalSignsDTO> update(@PathVariable Long id, @Valid @RequestBody VitalSignsDTO vitalSignsDTO) {
        return ResponseEntity.ok(service.update(id, vitalSignsDTO));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get vital signs record by ID")
    public ResponseEntity<VitalSignsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get vital signs records by patient ID")
    public ResponseEntity<List<VitalSignsDTO>> findByPatientId(@PathVariable String patientId) {
        return ResponseEntity.ok(service.findByPatientId(patientId));
    }

    @GetMapping
    @Operation(summary = "Get all vital signs records")
    public ResponseEntity<List<VitalSignsDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete vital signs record")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
} 