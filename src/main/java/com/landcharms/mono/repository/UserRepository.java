package com.landcharms.mono.repository;

import com.landcharms.mono.domain.UserLand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLand, Long> {
}
