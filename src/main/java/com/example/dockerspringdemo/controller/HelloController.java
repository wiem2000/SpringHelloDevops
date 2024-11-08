package com.example.dockerspringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




import org.springframework.web.bind.annotation.PathVariable;

import com.example.dockerspringdemo.entity.UsersEntity;
import com.example.dockerspringdemo.service.UsersService;

@RestController
public class HelloController {
	

	 private final UsersService usersService;

	   
	    public HelloController(UsersService usersService) {
	        this.usersService = usersService;
	    }

    @GetMapping("/")
    public String bonjour() {
        return "Hello Im an App!";
    }
    
    @GetMapping("/hello")
    public String gretting() {
        return "Hello";
    }
    


    
    @GetMapping("/users")
    public List<UsersEntity> getAllUsers() {
        return usersService.getAllUsers();
    }


    @GetMapping("/users/{id}")
    public UsersEntity getUserById(@PathVariable("id") Integer id) {
        return usersService.getUserById(id);
    }
    

}