package com.example.MyWebApp;

import com.example.MyWebApp.user.User;
import com.example.MyWebApp.user.UserRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("Hasibulkabir@gmail.com");
        user.setPassword("Ujdj&&8e12");
        user.setFirstName("Hasibul");
        user.setFirstName("Kabir");

        User saveUser = repo.save(user);
        org.assertj.core.api.Assertions.assertThat(saveUser).isNotNull();
        org.assertj.core.api.Assertions.assertThat(saveUser.getId()).isGreaterThan(0);



    }

}
