package com.example.adminpanel.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository provides JPA related methods
 * such as flushing the persistence context and delete records in a batch
 *
 * The Spring Data Repository will auto-generate the implementation based on the name we provided it
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
