package com.landcharms.mono.repository;

import com.landcharms.mono.domain.Address;
import com.landcharms.mono.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
