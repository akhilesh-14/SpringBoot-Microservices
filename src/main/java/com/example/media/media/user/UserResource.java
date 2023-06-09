package com.example.media.media.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    private UserDAOService service;
    UserResource(UserDAOService service){
        this.service = service;
    }
@GetMapping("/users")
    public List<User> retriveAllUsers(){
        return service.FindAll();
    }

    @GetMapping("/users/{id}")
    public User retriveAllUsers(@PathVariable int id){
        return service.findOne(id);
    }
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.addUser(user);

    }
}
