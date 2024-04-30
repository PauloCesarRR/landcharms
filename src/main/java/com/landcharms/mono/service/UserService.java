package com.landcharms.mono.service;

import com.landcharms.mono.domain.UserLand;
import com.landcharms.mono.infra.exceptions.CategoryNotFoundException;
import com.landcharms.mono.repository.UserRepository;
import com.landcharms.mono.utils.UpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserLand> getAll() {
        return userRepository.findAll();
    }

    public UserLand getById(Long id) {
       return userRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
    }

    public UserLand create(UserLand userLand) {
        return userRepository.save(userLand);
    }

    public UserLand update(Long id, UserLand userLand) {
        UserLand actualUserLand = userRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException(id.toString())
        );
        
        UpdateUtils.copyNonNullProperties(actualUserLand, userLand);
        
        return userRepository.save(userLand);
    }

}
