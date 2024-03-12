package com.landcharms.mono.controller;


import com.landcharms.mono.domain.Address;
import com.landcharms.mono.domain.Category;
import com.landcharms.mono.service.AddressService;
import com.landcharms.mono.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<URI> create(Category category){
        Category createdCategory = categoryService.create(category);
        return ResponseEntity.created(getById(createdCategory.getId()).getHeaders().getLocation()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, Category category){
        Category updatedCategory= categoryService.update(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

}
