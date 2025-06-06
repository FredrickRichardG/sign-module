package com.healthcare.vitalsigns.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthcare.vitalsigns.dto.VitalSignsDTO;
import com.healthcare.vitalsigns.entity.VitalSigns;
import com.healthcare.vitalsigns.repository.VitalSignsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class VitalSignsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VitalSignsRepository vitalSignsRepository;

    private VitalSigns vitalSigns;
    private VitalSignsDTO vitalSignsDTO;

    @BeforeEach
    void setUp(){
        vitalSignsRepository.deleteAll();

        vitalSigns = new VitalSigns();
        vitalSigns.setBloodSugar(130.0);
        vitalSigns.setHeight(5.9);
        vitalSigns.setPulse(80);
        vitalSigns.setDiastolicBP(120);
        vitalSigns.setPatientId("01HW00");
        vitalSigns.setPtInr(12.1);
        vitalSigns.setWeight(60.8);
        vitalSigns.setRespirations(2);
        vitalSigns.setTemperature(31.0);
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
        vitalSignsDTO.setTemperature(31.0);
        vitalSignsDTO.setSpo2Saturation(90);
        vitalSignsDTO.setSystolicBP(80);
        vitalSignsDTO.setNotes("All good");

        vitalSigns = vitalSignsRepository.save(vitalSigns);

    }

    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    void createVitalSigns_Success() throws Exception{

        mockMvc.perform(post("/api/v1/vital-signs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vitalSignsDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.patientId").value("01HW00"))
                .andExpect(jsonPath("$.notes").value("All good"));
    }


    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    void updateVitalSigns_Success() throws Exception{

        mockMvc.perform(put("/api/v1/vital-signs/{id}",vitalSigns.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vitalSignsDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patientId").value("01HW00"))
                .andExpect(jsonPath("$.notes").value("All good"));
    }

    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    void findByIdVitalSigns_Success() throws Exception{

        mockMvc.perform(get("/api/v1/vital-signs/{id}",vitalSigns.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patientId").value("01HW00"))
                .andExpect(jsonPath("$.notes").value("All good"));
    }


    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    void findByPatientIdVitalSigns_Success() throws Exception{

        mockMvc.perform(get("/api/v1/vital-signs/patient/{patientId}",vitalSigns.getPatientId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].notes").value(vitalSigns.getNotes()));
    }

    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    void findAllVitalSigns_Success() throws Exception{

        mockMvc.perform(get("/api/v1/vital-signs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].notes").value(vitalSigns.getNotes()));
    }

    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    void deletePatientIdVitalSigns_Success() throws Exception{

        mockMvc.perform(delete("/api/v1/vital-signs/{id}",vitalSigns.getId()))
                .andExpect(status().isNoContent());
    }

}
