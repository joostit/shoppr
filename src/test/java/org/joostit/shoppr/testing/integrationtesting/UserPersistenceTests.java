package org.joostit.shoppr.testing.integrationtesting;


import org.assertj.core.api.Assert;
import org.joostit.shoppr.models.User;
import org.joostit.shoppr.repos.UserRepository;
import org.joostit.shoppr.services.Impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserPersistenceTests {

    UserDetailsServiceImpl userService;

    UserRepository userRepo;

    @Autowired
    public UserPersistenceTests(UserDetailsServiceImpl userService, UserRepository userRepo){
        this.userService = userService;
        this.userRepo = userRepo;
    }


    @Test
    void testRegisterUser(){

        String name = "XXTESTCXX";
        String role = "XXROLEXX";
        String pw = "XXXPWXX";


        // Use the service to add a user
        userService.addUser(name, pw, role);

        //Retrieve the user from the repository. Would be even better to do this with a raw SQL query
        // to find integrations bugs in the service/repo
        User found = userRepo.getUserByUsername(name);

        assertThat(found).isNotNull();

        assertThat(found.getUsername()).isEqualTo(name);
        assertThat(found.getRole()).isEqualTo(role);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertThat(encoder.matches(pw, found.getPassword())).isTrue();


    }


}
