package com.example.rest_exercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc 
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc.perform(get("/students"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$[0]").value("Alice"));
    }

    @Test
    public void testGetStudentById() throws Exception {
        mockMvc.perform(get("/students/99"))
               .andExpect(status().isOk());
    }

    @Test
    public void testMissingParameterReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/students/search"))
               .andExpect(status().isBadRequest());
    }
}