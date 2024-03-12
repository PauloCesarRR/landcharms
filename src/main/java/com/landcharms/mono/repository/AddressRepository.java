package com.landcharms.mono.repository;

import com.landcharms.mono.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
