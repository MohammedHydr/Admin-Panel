package com.example.adminpanel.repository;

import com.example.adminpanel.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository provides JPA related methods
 * such as flushing the persistence context and delete records in a batch
 *
 * The Spring Data Repository will auto-generate the implementation based on the name we provided it
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
