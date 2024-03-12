package com.landcharms.mono.service;

import com.landcharms.mono.domain.Spaces;
import com.landcharms.mono.domain.User;
import com.landcharms.mono.infra.exceptions.CategoryNotFoundException;
import com.landcharms.mono.repository.SpacesRepository;
import com.landcharms.mono.repository.UserRepository;
import com.landcharms.mono.utils.UpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpacesService {

    @Autowired
    private SpacesRepository spacesRepository;


    public List<Spaces> getAll() {
        return spacesRepository.findAll();
    }

    public Spaces getById(Long id) {
       return spacesRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
    }

    public Spaces create(Spaces spaces) {
        return spacesRepository.save(spaces);
    }

    public Spaces update(Long id, Spaces spaces) {
        Spaces actualSpaces = spacesRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
        
        UpdateUtils.copyNonNullProperties(actualSpaces, spaces);
        
        return spacesRepository.save(spaces);
    }

}
