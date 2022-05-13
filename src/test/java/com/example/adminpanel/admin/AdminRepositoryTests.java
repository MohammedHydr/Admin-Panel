package com.example.adminpanel.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest // to indicate that this test class will be running as data jpa test
@AutoConfigureTestDatabase(replace = NONE)  // we want to use real database AND replace None
                                            // because by default string and dataJpa we use an in-memory database,
                                            // but I want to use the real database
                                            // create the table users
@Rollback(false)
public class AdminRepositoryTests {

    @Autowired
    private AdminRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void tsetCreateAdmin(){
        Admin admin = new Admin();
        admin.setEmail("ali@gmail.com");
        admin.setPassword("Ali2022");
        admin.setFirstName("Ali");
        admin.setLastName("Haydar");

        Admin savedAdmin = repo.save(admin);

        Admin existAdmin = entityManager.find(Admin.class,savedAdmin.getId());

        assertThat(existAdmin.getEmail()).isEqualTo(admin.getEmail());

    }
    @Test
    public void testFindAdminByEmail(){
        String email = "mo@e.com";
        Admin admin = repo.findByEmail(email);

        assertThat(admin).isNotNull();
    }

}
