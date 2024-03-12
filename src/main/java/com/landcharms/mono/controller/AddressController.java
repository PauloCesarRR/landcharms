package com.landcharms.mono.controller;


import com.landcharms.mono.domain.Address;
import com.landcharms.mono.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<URI> create(Address address){
        Address createdAddress = addressService.create(address);
        return ResponseEntity.created(getById(createdAddress.getId()).getHeaders().getLocation()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, Address address){
        Address updatedAddress = addressService.update(id, address);
        return ResponseEntity.ok(updatedAddress);
    }

}
