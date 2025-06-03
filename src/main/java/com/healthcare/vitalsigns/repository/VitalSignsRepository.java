package com.healthcare.vitalsigns.repository;

import com.healthcare.vitalsigns.entity.VitalSigns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalSignsRepository extends JpaRepository<VitalSigns, Long> {
    List<VitalSigns> findByPatientIdOrderByCreatedDesc(String patientId);
} 