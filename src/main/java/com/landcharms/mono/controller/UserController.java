package com.landcharms.mono.controller;


import com.landcharms.mono.domain.UserLand;
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
    public ResponseEntity<UserLand> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserLand>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<URI> create(UserLand userLand){
        UserLand createdUserLand = userService.create(userLand);
        return ResponseEntity.created(getById(createdUserLand.getId()).getHeaders().getLocation()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserLand> update(@PathVariable Long id, UserLand userLand){
        UserLand updatedUserLand = userService.update(id, userLand);
        return ResponseEntity.ok(updatedUserLand);
    }

}
