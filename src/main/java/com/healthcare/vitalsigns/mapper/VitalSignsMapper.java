package com.healthcare.vitalsigns.mapper;

import com.healthcare.vitalsigns.dto.VitalSignsDTO;
import com.healthcare.vitalsigns.entity.VitalSigns;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VitalSignsMapper {
    
    VitalSignsDTO toDTO(VitalSigns entity);
    
    VitalSigns toEntity(VitalSignsDTO dto);
    
    void updateEntityFromDTO(VitalSignsDTO dto, @MappingTarget VitalSigns entity);
} 