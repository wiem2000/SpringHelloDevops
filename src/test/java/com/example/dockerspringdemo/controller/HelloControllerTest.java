package com.example.dockerspringdemo.controller;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.dockerspringdemo.entity.UsersEntity;
import com.example.dockerspringdemo.service.UsersService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc

public class HelloControllerTest {
	
	   @Autowired
	    private MockMvc mockMvc;


	    @Mock
	    private UsersService usersService;

	    @InjectMocks
	    private HelloController usersController;

	    
	    private List<UsersEntity> usersList;

	    @BeforeEach
	    public void setUp() {
	      
	        usersList = Arrays.asList(
	                new UsersEntity(1, "john_doe", "John", "Doe", "ADMIN"),
	                new UsersEntity(2, "jane_smith", "Jane", "Smith", "USER"),
	                new UsersEntity(3, "alex_jones", "Alex", "Jones", "MODERATOR")
	        );
	    }

	    @Test
	    public void testGetAllUsers() throws Exception {
	     
	        when(usersService.getAllUsers()).thenReturn(usersList);

	        
	        mockMvc.perform(get("/users"))
	                .andExpect(status().isOk()) 
	                .andExpect(content().json("["
	                        + "{\"usersId\":1,\"username\":\"john_doe\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"userRole\":\"ADMIN\"},"
	                        + "{\"usersId\":2,\"username\":\"jane_smith\",\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"userRole\":\"USER\"},"
	                        + "{\"usersId\":3,\"username\":\"alex_jones\",\"firstName\":\"Alex\",\"lastName\":\"Jones\",\"userRole\":\"MODERATOR\"}"
	                        + "]")); 
	    }

	    @Test
	    public void testGetUserById() throws Exception {
	    
	        when(usersService.getUserById(1)).thenReturn(usersList.get(0));

	      
	        mockMvc.perform(get("/users/1"))
	                .andExpect(status().isOk()) 
	                .andExpect(content().json("{"
	                        + "\"usersId\":1,\"username\":\"john_doe\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"userRole\":\"ADMIN\""
	                        + "}")); 
	    }

	    @Test
	    public void testGetUserByIdNotFound() throws Exception {
	     
	        when(usersService.getUserById(999)).thenReturn(null);

	      
	        mockMvc.perform(get("/users/999"))
	                .andExpect(status().isNotFound()); 
	    }
	



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
