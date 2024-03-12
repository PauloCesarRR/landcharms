package com.landcharms.mono.repository;

import com.landcharms.mono.domain.Address;
import com.landcharms.mono.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
