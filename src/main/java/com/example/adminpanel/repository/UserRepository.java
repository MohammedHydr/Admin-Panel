package com.example.adminpanel.repository;

import com.example.adminpanel.entity.Admin;
import com.example.adminpanel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository provides JPA related methods
 * such as flushing the persistence context and delete records in a batch
 *
 * The Spring Data Repository will auto-generate the implementation based on the name we provided it
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // this is the query we are actually running will be auto generated
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

}
