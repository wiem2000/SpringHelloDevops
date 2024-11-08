package com.example.dockerspringdemo.service;
import com.example.dockerspringdemo.entity.UsersEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsersService {

    public List<UsersEntity> getAllUsers() {
        List<UsersEntity> users = new ArrayList<>();
        
      
        users.add(new UsersEntity(1, "john_doe", "John", "Doe", "ADMIN"));
        users.add(new UsersEntity(2, "jane_smith", "Jane", "Smith", "USER"));
        users.add(new UsersEntity(3, "alex_jones", "Alex", "Jones", "MODERATOR"));
        
        return users;
    }
   
 
    public Optional<UsersEntity> getUserById(Integer id) {
        List<UsersEntity> users = getAllUsers();
        return users.stream()
                    .filter(user -> user.getUsersId().equals(id))
                    .findFirst(); 
    }
}
