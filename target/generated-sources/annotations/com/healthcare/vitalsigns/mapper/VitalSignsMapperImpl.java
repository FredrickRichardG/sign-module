package com.healthcare.vitalsigns.mapper;

import com.healthcare.vitalsigns.dto.VitalSignsDTO;
import com.healthcare.vitalsigns.entity.VitalSigns;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-03T17:01:14+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class VitalSignsMapperImpl implements VitalSignsMapper {

    @Override
    public VitalSignsDTO toDTO(VitalSigns entity) {
        if ( entity == null ) {
            return null;
        }

        VitalSignsDTO vitalSignsDTO = new VitalSignsDTO();

        vitalSignsDTO.setBloodSugar( entity.getBloodSugar() );
        vitalSignsDTO.setDiastolicBP( entity.getDiastolicBP() );
        vitalSignsDTO.setHeight( entity.getHeight() );
        vitalSignsDTO.setId( entity.getId() );
        vitalSignsDTO.setNotes( entity.getNotes() );
        vitalSignsDTO.setPatientId( entity.getPatientId() );
        vitalSignsDTO.setPtInr( entity.getPtInr() );
        vitalSignsDTO.setPulse( entity.getPulse() );
        vitalSignsDTO.setRespirations( entity.getRespirations() );
        vitalSignsDTO.setSpo2Saturation( entity.getSpo2Saturation() );
        vitalSignsDTO.setSystolicBP( entity.getSystolicBP() );
        vitalSignsDTO.setTemperature( entity.getTemperature() );
        vitalSignsDTO.setWeight( entity.getWeight() );

        return vitalSignsDTO;
    }

    @Override
    public VitalSigns toEntity(VitalSignsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VitalSigns vitalSigns = new VitalSigns();

        vitalSigns.setBloodSugar( dto.getBloodSugar() );
        vitalSigns.setDiastolicBP( dto.getDiastolicBP() );
        vitalSigns.setHeight( dto.getHeight() );
        vitalSigns.setId( dto.getId() );
        vitalSigns.setNotes( dto.getNotes() );
        vitalSigns.setPatientId( dto.getPatientId() );
        vitalSigns.setPtInr( dto.getPtInr() );
        vitalSigns.setPulse( dto.getPulse() );
        vitalSigns.setRespirations( dto.getRespirations() );
        vitalSigns.setSpo2Saturation( dto.getSpo2Saturation() );
        vitalSigns.setSystolicBP( dto.getSystolicBP() );
        vitalSigns.setTemperature( dto.getTemperature() );
        vitalSigns.setWeight( dto.getWeight() );

        return vitalSigns;
    }

    @Override
    public void updateEntityFromDTO(VitalSignsDTO dto, VitalSigns entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getBloodSugar() != null ) {
            entity.setBloodSugar( dto.getBloodSugar() );
        }
        if ( dto.getDiastolicBP() != null ) {
            entity.setDiastolicBP( dto.getDiastolicBP() );
        }
        if ( dto.getHeight() != null ) {
            entity.setHeight( dto.getHeight() );
        }
        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNotes() != null ) {
            entity.setNotes( dto.getNotes() );
        }
        if ( dto.getPatientId() != null ) {
            entity.setPatientId( dto.getPatientId() );
        }
        if ( dto.getPtInr() != null ) {
            entity.setPtInr( dto.getPtInr() );
        }
        if ( dto.getPulse() != null ) {
            entity.setPulse( dto.getPulse() );
        }
        if ( dto.getRespirations() != null ) {
            entity.setRespirations( dto.getRespirations() );
        }
        if ( dto.getSpo2Saturation() != null ) {
            entity.setSpo2Saturation( dto.getSpo2Saturation() );
        }
        if ( dto.getSystolicBP() != null ) {
            entity.setSystolicBP( dto.getSystolicBP() );
        }
        if ( dto.getTemperature() != null ) {
            entity.setTemperature( dto.getTemperature() );
        }
        if ( dto.getWeight() != null ) {
            entity.setWeight( dto.getWeight() );
        }
    }
}
