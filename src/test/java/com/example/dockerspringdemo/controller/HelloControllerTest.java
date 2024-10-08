package com.example.dockerspringdemo.controller;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class HelloControllerTest {
	
	   @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void testBonjourEndpoint() throws Exception {
	        this.mockMvc.perform(get("/"))
	            .andExpect(status().isOk())
	            .andExpect(content().string("Hello Im an App!"));
	    }

	    @Test
	    public void testGrettingEndpoint() throws Exception {
	        this.mockMvc.perform(get("/hello"))
	            .andExpect(status().isOk())
	            .andExpect(content().string("Hello"));
	    }
	    

}
