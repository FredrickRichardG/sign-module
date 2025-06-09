package com.healthcare.vitalsigns.service;

import com.healthcare.vitalsigns.annotation.ExecutionTime;
import com.healthcare.vitalsigns.dto.VitalSignsDTO;
import com.healthcare.vitalsigns.entity.VitalSigns;
import com.healthcare.vitalsigns.mapper.VitalSignsMapper;
import com.healthcare.vitalsigns.repository.VitalSignsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class VitalSignsService {

    private final VitalSignsRepository repository;
    private final VitalSignsMapper mapper;

    @CachePut(value = "VITAL_CACHE",key = "#result.id")
    public VitalSignsDTO create(VitalSignsDTO vitalSignsDTO) {
        VitalSigns entity = mapper.toEntity(vitalSignsDTO);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @CachePut(value = "VITAL_CACHE",key = "#id")
    public VitalSignsDTO update(Long id, VitalSignsDTO vitalSignsDTO) {
        VitalSigns entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("VitalSigns not found with id: " + id));
        
        mapper.updateEntityFromDTO(vitalSignsDTO, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Cacheable(value = "VITAL_CACHE",key = "#id")
    @Transactional(readOnly = true)
    public VitalSignsDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("VitalSigns not found with id: " + id));
    }

    @ExecutionTime
    @Transactional(readOnly = true)
    public List<VitalSignsDTO> findByPatientId(String patientId) {
        return repository.findByPatientIdOrderByCreatedDesc(patientId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<VitalSignsDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @CacheEvict(value = "VITAL_CACHE",key = "#id")
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("VitalSigns not found with id: " + id);
        }
        repository.deleteById(id);
    }
} 