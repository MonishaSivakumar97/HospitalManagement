package com.example.doctor.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.doctor.controller.DoctorController;
import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;
import com.example.doctor.service.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
	
@RunWith(SpringRunner.class)
	@WebMvcTest(DoctorController.class)
	public class DoctorTest {
	  @MockBean
	  private DoctorRepository doctorRepository;
	  
	  @MockBean
	  private DoctorService doctorService;

	  
	  @MockBean
	  private Doctor doctor;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;

	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Doctor doctor=new Doctor(5, "Priya", "Female", "psycharstist", 1);

	    mockMvc.perform(post("/doctors").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(doctor)))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }

	  @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=5;
	    String name="VL";
	    Doctor doctor=new Doctor(id, name, "Female", "psycharstist", 1);

	    when(doctorRepository.findById(id)).thenReturn(Optional.of(doctor));
	    mockMvc.perform(get("/doctors/get/{id}", id)).andExpect(status().isOk())
	        .andDo(print());
	  }
	  

	  
//	  '1', '26', 'Male', 'Sampath', '2', 'ent'
//	  '2', '23', 'Female', 'Nisha', '3', 'Brain'
//	  '3', '34', 'Male', 'Siva', '3', 'Brain'
//	  '4', '22', 'Female', 'Nandhini', '1', 'mental disorder'
//	  '5', '55', 'Female', 'Priya', '1', 'psycharstist'


	 // @Test
	  //void shouldReturnListOfDoctors() throws Exception {
	    //List<Doctor> doctors = new ArrayList<>(
	      //  Arrays.asList(new Doctor(1, "Sampath", "Male", "ent", 2,26),
	        //    new Doctor(2, "Nisha", "Female", "Brain", 3,23),
	          //  new Doctor(3, "Siva", "Male", "Brain", 3,34),
	           // new Doctor(4, "Nandhini", "Female", "mental disorder", 1, 22),
	            //new Doctor(5, "Priya", "Female", "psycharstist", 1, 55)
	            //));

	  //  when(doctorRepository.findAll()).thenReturn(doctors);
	    //mockMvc.perform(get("/doctors/"))
	      //  .andExpect(status().isOk())
	        //.andExpect(jsonPath("$.size()").value(doctors.size()))
	        //.andDo(print());
	  //}

}