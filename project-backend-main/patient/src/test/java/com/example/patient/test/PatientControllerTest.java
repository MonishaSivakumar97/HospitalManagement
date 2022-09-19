package com.example.patient.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.patient.controller.PatientController;
import com.example.patient.entity.Patient;
import com.example.patient.repository.PatientRepository;
import com.example.patient.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(PatientController.class)
public class PatientControllerTest {
	
	  @MockBean
	  private PatientRepository patientRepository;
	  
	  @MockBean
	  private PatientService patientService;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;

	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Patient patient=new Patient(1, "Sindhuja", "Sampath", "1996-11-23","ent",
				1);

	    mockMvc.perform(post("/patients/").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(patient)))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }

	 /* @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=3;
	    String name="Harry";
	    Patient patient=new Patient(id,"Thiya", "Keerthi", "19-09-2022","skin",1);

	    mockMvc.perform(get("/doctors/get/{id}", id)).andExpect(status().isOk())
	      
	        .andDo(print());
	  }*/
	  


}