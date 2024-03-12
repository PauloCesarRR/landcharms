package com.landcharms.mono.controller;


import com.landcharms.mono.domain.Spaces;
import com.landcharms.mono.domain.User;
import com.landcharms.mono.service.SpacesService;
import com.landcharms.mono.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/spaces")
public class SpacesController {

    @Autowired
    private SpacesService spacesService;

    @GetMapping("/{id}")
    public ResponseEntity<Spaces> getById(@PathVariable Long id){
        return ResponseEntity.ok(spacesService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Spaces>> getAll(){
        return ResponseEntity.ok(spacesService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<URI> create(Spaces spaces){
        Spaces createdSpace = spacesService.create(spaces);
        return ResponseEntity.created(getById(createdSpace.getId()).getHeaders().getLocation()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Spaces> update(@PathVariable Long id, Spaces spaces){
        Spaces updatedSpace = spacesService.update(id, spaces);
        return ResponseEntity.ok(updatedSpace);
    }

}
