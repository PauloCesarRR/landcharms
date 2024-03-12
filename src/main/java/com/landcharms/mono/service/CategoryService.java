package com.landcharms.mono.service;

import com.landcharms.mono.domain.Address;
import com.landcharms.mono.domain.Category;
import com.landcharms.mono.infra.exceptions.AddressNotFoundException;
import com.landcharms.mono.infra.exceptions.CategoryNotFoundException;
import com.landcharms.mono.repository.AddressRepository;
import com.landcharms.mono.repository.CategoryRepository;
import com.landcharms.mono.utils.UpdateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;


    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
       return categoryRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Category actualCategory = categoryRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
        
        UpdateUtils.copyNonNullProperties(actualCategory, category);
        
        return categoryRepository.save(category);
    }

}
