package com.healthcare.vitalsigns.service;

import com.healthcare.vitalsigns.dto.VitalSignsDTO;
import com.healthcare.vitalsigns.entity.VitalSigns;
import com.healthcare.vitalsigns.mapper.VitalSignsMapper;
import com.healthcare.vitalsigns.repository.VitalSignsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VitalSignsServiceUnitTest {

    @Mock
    private VitalSignsRepository vitalSignsRepository;

    @Mock
    private VitalSignsMapper vitalSignsMapper;

    @InjectMocks
    private VitalSignsService vitalSignsService;

    private VitalSigns vitalSigns;

    private VitalSignsDTO vitalSignsDTO;


    @BeforeEach
    void setUp(){
        vitalSigns = new VitalSigns();
        vitalSigns.setBloodSugar(130.0);
        vitalSigns.setHeight(5.9);
        vitalSigns.setPulse(80);
        vitalSigns.setDiastolicBP(120);
        vitalSigns.setPatientId("01HW00");
        vitalSigns.setPtInr(12.1);
        vitalSigns.setWeight(60.8);
        vitalSigns.setRespirations(2);
        vitalSigns.setTemperature(97.0);
        vitalSigns.setSpo2Saturation(90);
        vitalSigns.setSystolicBP(80);
        vitalSigns.setNotes("All good");


        vitalSignsDTO = new VitalSignsDTO();
        vitalSignsDTO.setBloodSugar(130.0);
        vitalSignsDTO.setHeight(5.9);
        vitalSignsDTO.setPulse(80);
        vitalSignsDTO.setDiastolicBP(120);
        vitalSignsDTO.setPatientId("01HW00");
        vitalSignsDTO.setPtInr(12.1);
        vitalSignsDTO.setWeight(60.8);
        vitalSignsDTO.setRespirations(2);
        vitalSignsDTO.setTemperature(97.0);
        vitalSignsDTO.setSpo2Saturation(90);
        vitalSignsDTO.setSystolicBP(80);
        vitalSignsDTO.setNotes("All good");

    }

    @Test
    void createVitalSign_Success(){
        
        //Arrange
        when(vitalSignsMapper.toEntity(any(VitalSignsDTO.class))).thenReturn(vitalSigns);
        when(vitalSignsRepository.save(any(VitalSigns.class))).thenReturn(vitalSigns);
        when(vitalSignsMapper.toDTO(any(VitalSigns.class))).thenReturn(vitalSignsDTO);


        // Act
        VitalSignsDTO result = vitalSignsService.create(vitalSignsDTO);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getPatientId()).isEqualTo(vitalSignsDTO.getPatientId());
        verify(vitalSignsRepository).save(any(VitalSigns.class));
    }

    @Test
    void updateVitalSign_Success(){

        //Arrange
        when(vitalSignsRepository.findById(any(Long.class))).thenReturn(Optional.of(vitalSigns));
        doNothing().when(vitalSignsMapper).updateEntityFromDTO(any(VitalSignsDTO.class),any(VitalSigns.class));
        when(vitalSignsRepository.save(any(VitalSigns.class))).thenReturn(vitalSigns);
        when(vitalSignsMapper.toDTO(any(VitalSigns.class))).thenReturn(vitalSignsDTO);


        // Act
        VitalSignsDTO result = vitalSignsService.update( 1L,vitalSignsDTO);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getPatientId()).isEqualTo(vitalSignsDTO.getPatientId());
        verify(vitalSignsRepository).save(any(VitalSigns.class));
    }

    @Test
    void updateVitalSign_Failure(){

        //Arrange
        doThrow(new EntityNotFoundException("VitalSigns not found with id: 1L")).when(vitalSignsRepository).findById(any(Long.class));

        // Act & Assert

        assertThatThrownBy(() -> vitalSignsService.update(1L,vitalSignsDTO))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("VitalSigns not found with id: 1L");
    }

    @Test
    void findByIdVitalSign_Success(){


        //Arrange
        when(vitalSignsRepository.findById(any(Long.class))).thenReturn(Optional.of(vitalSigns));
        when(vitalSignsMapper.toDTO(any(VitalSigns.class))).thenReturn(vitalSignsDTO);


        // Act
        VitalSignsDTO result = vitalSignsService.findById( 1L);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getPatientId()).isEqualTo(vitalSignsDTO.getPatientId());
        verify(vitalSignsRepository).findById(any(Long.class));
    }

    @Test
    void findByIdVitalSign_Failure(){

        //Arrange
        doThrow(new EntityNotFoundException("VitalSigns not found with id: 1L")).when(vitalSignsRepository).findById(any(Long.class));

        // Act & Assert

        assertThatThrownBy(() -> vitalSignsService.findById(1L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("VitalSigns not found with id: 1L");
    }


    @Test
    void findByPatientIdVitalSign_Success(){

        List<VitalSigns> vitalSignsList = new ArrayList<>();
        vitalSignsList.add(vitalSigns);

        //Arrange
        when(vitalSignsRepository.findByPatientIdOrderByCreatedDesc(any(String.class))).thenReturn(vitalSignsList);
        when(vitalSignsMapper.toDTO(any(VitalSigns.class))).thenReturn(vitalSignsDTO);

        // Act
        List<VitalSignsDTO> result = vitalSignsService.findByPatientId("01HW00");

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.get(0).getPatientId()).isEqualTo(vitalSignsDTO.getPatientId());
        verify(vitalSignsRepository).findByPatientIdOrderByCreatedDesc(any(String.class));
    }

    @Test
    void findAll_Success(){

        List<VitalSigns> vitalSignsList = new ArrayList<>();
        vitalSignsList.add(vitalSigns);

        //Arrange
        when(vitalSignsRepository.findAll()).thenReturn(vitalSignsList);
        when(vitalSignsMapper.toDTO(any(VitalSigns.class))).thenReturn(vitalSignsDTO);

        // Act
        List<VitalSignsDTO> result = vitalSignsService.findAll();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.get(0).getPatientId()).isEqualTo(vitalSignsDTO.getPatientId());
        verify(vitalSignsRepository).findAll();
    }

    @Test
    void deleteVitalSign_Success(){

        //Arrange
        when(vitalSignsRepository.existsById(any(Long.class))).thenReturn(true);
        doNothing().when(vitalSignsRepository).deleteById(any(Long.class));


        // Act
        vitalSignsService.delete( 1L);

        // Assert

        verify(vitalSignsRepository).deleteById(any(Long.class));
    }

}
