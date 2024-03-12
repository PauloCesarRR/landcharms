package com.landcharms.mono.service;

import com.landcharms.mono.domain.Address;
import com.landcharms.mono.infra.exceptions.AddressNotFoundException;
import com.landcharms.mono.repository.AddressRepository;
import com.landcharms.mono.utils.UpdateUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AddressService {

    private AddressRepository addressRepository;

    public Address getById(Long id) {
       return addressRepository.findById(id).orElseThrow(() ->
                new AddressNotFoundException(id.toString())
        );
    }

    public void create(Address address) {
        addressRepository.save(address);
    }

    public Address update(Long id, Address address) {
        Address actualAddress = addressRepository.findById(id).orElseThrow(() ->
                new AddressNotFoundException(id.toString())
        );
        
        UpdateUtils.copyNonNullProperties(actualAddress, address);
        
        return addressRepository.save(address);
    }

}
