package com.landcharms.mono.controller;


import com.landcharms.mono.domain.Category;
import com.landcharms.mono.domain.User;
import com.landcharms.mono.service.CategoryService;
import com.landcharms.mono.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<URI> create(User user){
        User createdUser = userService.create(user);
        return ResponseEntity.created(getById(createdUser.getId()).getHeaders().getLocation()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, User user){
        User updatedUser = userService.update(id, user);
        return ResponseEntity.ok(updatedUser);
    }

}
