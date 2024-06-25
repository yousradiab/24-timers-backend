package com.example.programmering2024.api;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.service.DeltagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DeltagerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeltagerService deltagerService;

    private DeltagerDto deltager1;
    private DeltagerDto deltager2;

    @BeforeEach
    public void setUp() {
        deltager1 = new DeltagerDto(1L, "Deltager 1");
        deltager2 = new DeltagerDto(2L, "Deltager 2");
    }

    @Test
    public void testGetAllDeltager() throws Exception {
        List<DeltagerDto> deltagerList = Arrays.asList(deltager1, deltager2);
        Mockito.when(deltagerService.getAllDeltager()).thenReturn(deltagerList);

        mockMvc.perform(MockMvcRequestBuilders.get("/deltager")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(deltager1.getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(deltager1.getName())))
                .andExpect(jsonPath("$[1].id", is(deltager2.getId().intValue())))
                .andExpect(jsonPath("$[1].name", is(deltager2.getName())));
    }

    @Test
    public void testAddDeltager() throws Exception {
        DeltagerDto newDeltager = new DeltagerDto(null, "New Deltager");
        DeltagerDto savedDeltager = new DeltagerDto(3L, "New Deltager");
        Mockito.when(deltagerService.addDeltager(any(DeltagerDto.class))).thenReturn(savedDeltager);

        mockMvc.perform(MockMvcRequestBuilders.post("/createdeltager")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"New Deltager\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(savedDeltager.getId().intValue())))
                .andExpect(jsonPath("$.name", is(savedDeltager.getName())));
    }

    @Test
    public void testGetDeltagerById() throws Exception {
        Mockito.when(deltagerService.getDeltagerById(1L)).thenReturn(deltager1);

        mockMvc.perform(MockMvcRequestBuilders.get("/deltager/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(deltager1.getId().intValue())))
                .andExpect(jsonPath("$.name", is(deltager1.getName())));
    }

    @Test
    public void testUpdateDeltager() throws Exception {
        DeltagerDto updatedDeltager = new DeltagerDto(1L, "Updated Deltager");
        Mockito.when(deltagerService.updateDeltager(eq(1L), any(DeltagerDto.class))).thenReturn(updatedDeltager);

        mockMvc.perform(MockMvcRequestBuilders.put("/deltager/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Updated Deltager\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(updatedDeltager.getId().intValue())))
                .andExpect(jsonPath("$.name", is(updatedDeltager.getName())));
    }
/*
    @Test
    public void testDeleteDeltager() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/deltager/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        Mockito.verify(deltagerService, Mockito.times(1)).deleteDeltager(1L);
    }

 */
}
