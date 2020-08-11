package com.restfulService.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfulService.beans.Student;
import com.restfulService.beans.StudentRegistrationReply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UT_StudentRegistationController {
	
	@Autowired private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void Setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testStudentRegistation() throws Exception {
		String name = "jigar";
		int age = 2;
		String registrationNumber = "123456";
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		student.setRegistrationNumber(registrationNumber);
		StudentRegistrationReply response = new StudentRegistrationReply();
		response.setAge(age);
		response.setName(name);
		response.setRegistrationNumber(registrationNumber);
	response.setRegistrationStatus("Successful");
		
		ObjectMapper mapper = new ObjectMapper();
		String StudentJson = mapper.writeValueAsString(student);
		String StudentResponseJson = mapper.writeValueAsString(response);
		
		mockMvc.perform(post("/register/student/").contentType(MediaType.APPLICATION_JSON).content(StudentJson));
	
		
		
	}

}
