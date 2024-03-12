package com.landcharms.mono.repository;

import com.landcharms.mono.domain.Address;
import com.landcharms.mono.domain.Spaces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpacesRepository extends JpaRepository<Spaces, Long> {
}
