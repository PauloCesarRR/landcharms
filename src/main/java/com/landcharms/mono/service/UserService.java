package com.landcharms.mono.service;

import com.landcharms.mono.domain.Category;
import com.landcharms.mono.domain.User;
import com.landcharms.mono.infra.exceptions.CategoryNotFoundException;
import com.landcharms.mono.repository.CategoryRepository;
import com.landcharms.mono.repository.UserRepository;
import com.landcharms.mono.utils.UpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
       return userRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User actualUser = userRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
        
        UpdateUtils.copyNonNullProperties(actualUser, user);
        
        return userRepository.save(user);
    }

}
