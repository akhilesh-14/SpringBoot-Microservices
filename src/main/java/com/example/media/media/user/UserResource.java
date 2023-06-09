package com.example.media.media.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Object> createUser(@RequestBody User user){
         User SavedUser= service.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(SavedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
