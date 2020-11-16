package com.biopark.challenge;

import com.biopark.challenge.model.Comunication;
import com.biopark.challenge.service.ComunicationService;
import com.biopark.challenge.util.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComunicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    private ComunicationService comunicationService;

    private Comunication insertComunication() {
        Comunication comunication = new Comunication();
        comunication.setId(UUID.randomUUID());
        comunication.setUpdatedAt(LocalDateTime.now());
        comunication.setCreatedAt(LocalDateTime.now());
        comunication.setDateTimeSend(LocalDateTime.now());
        comunication.setMessage("TESTE");
        comunication.setReciver("Norton");
        comunication.setStatus(Status.OPEN);
        return comunication;
    }

    @Test
    public void createComunication() throws Exception {
        this.mockMvc.perform(post("/comunication")
                .content(objectMapper.writeValueAsString(insertComunication()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void getAllComunications() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/comunications")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.comunications").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.comunications[*].comunicationId").isNotEmpty());
    }
}
