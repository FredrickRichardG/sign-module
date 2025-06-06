package com.healthcare.vitalsigns.mapper;

import com.healthcare.vitalsigns.dto.VitalSignsDTO;
import com.healthcare.vitalsigns.entity.VitalSigns;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-06T14:07:36+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class VitalSignsMapperImpl implements VitalSignsMapper {

    @Override
    public VitalSignsDTO toDTO(VitalSigns entity) {
        if ( entity == null ) {
            return null;
        }

        VitalSignsDTO vitalSignsDTO = new VitalSignsDTO();

        vitalSignsDTO.setId( entity.getId() );
        vitalSignsDTO.setPatientId( entity.getPatientId() );
        vitalSignsDTO.setPulse( entity.getPulse() );
        vitalSignsDTO.setSystolicBP( entity.getSystolicBP() );
        vitalSignsDTO.setDiastolicBP( entity.getDiastolicBP() );
        vitalSignsDTO.setTemperature( entity.getTemperature() );
        vitalSignsDTO.setRespirations( entity.getRespirations() );
        vitalSignsDTO.setBloodSugar( entity.getBloodSugar() );
        vitalSignsDTO.setWeight( entity.getWeight() );
        vitalSignsDTO.setHeight( entity.getHeight() );
        vitalSignsDTO.setSpo2Saturation( entity.getSpo2Saturation() );
        vitalSignsDTO.setPtInr( entity.getPtInr() );
        vitalSignsDTO.setNotes( entity.getNotes() );

        return vitalSignsDTO;
    }

    @Override
    public VitalSigns toEntity(VitalSignsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VitalSigns vitalSigns = new VitalSigns();

        vitalSigns.setId( dto.getId() );
        vitalSigns.setPatientId( dto.getPatientId() );
        vitalSigns.setPulse( dto.getPulse() );
        vitalSigns.setSystolicBP( dto.getSystolicBP() );
        vitalSigns.setDiastolicBP( dto.getDiastolicBP() );
        vitalSigns.setTemperature( dto.getTemperature() );
        vitalSigns.setRespirations( dto.getRespirations() );
        vitalSigns.setBloodSugar( dto.getBloodSugar() );
        vitalSigns.setWeight( dto.getWeight() );
        vitalSigns.setHeight( dto.getHeight() );
        vitalSigns.setSpo2Saturation( dto.getSpo2Saturation() );
        vitalSigns.setPtInr( dto.getPtInr() );
        vitalSigns.setNotes( dto.getNotes() );

        return vitalSigns;
    }

    @Override
    public void updateEntityFromDTO(VitalSignsDTO dto, VitalSigns entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getPatientId() != null ) {
            entity.setPatientId( dto.getPatientId() );
        }
        if ( dto.getPulse() != null ) {
            entity.setPulse( dto.getPulse() );
        }
        if ( dto.getSystolicBP() != null ) {
            entity.setSystolicBP( dto.getSystolicBP() );
        }
        if ( dto.getDiastolicBP() != null ) {
            entity.setDiastolicBP( dto.getDiastolicBP() );
        }
        if ( dto.getTemperature() != null ) {
            entity.setTemperature( dto.getTemperature() );
        }
        if ( dto.getRespirations() != null ) {
            entity.setRespirations( dto.getRespirations() );
        }
        if ( dto.getBloodSugar() != null ) {
            entity.setBloodSugar( dto.getBloodSugar() );
        }
        if ( dto.getWeight() != null ) {
            entity.setWeight( dto.getWeight() );
        }
        if ( dto.getHeight() != null ) {
            entity.setHeight( dto.getHeight() );
        }
        if ( dto.getSpo2Saturation() != null ) {
            entity.setSpo2Saturation( dto.getSpo2Saturation() );
        }
        if ( dto.getPtInr() != null ) {
            entity.setPtInr( dto.getPtInr() );
        }
        if ( dto.getNotes() != null ) {
            entity.setNotes( dto.getNotes() );
        }
    }
}
