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

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("rayhanmalik@gmail.com");
        user.setPassword("UE39829J9*1");
        user.setFirstName("Rayhan");
        user.setLastName("Malik");

//        Used Alternative Method for Assertions For Database
        User saveUser = repo.save(user);
        org.assertj.core.api.Assertions.assertThat(saveUser).isNotNull();
        org.assertj.core.api.Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        org.assertj.core.api.Assertions.assertThat(users).hasSizeGreaterThan(0);


        for (User user : users){
            System.out.println(user);
            }

        }

        @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setLastName("Rahmatullah");
        repo.save(user);

        User updateuser =repo.findById(userId).get();
        org.assertj.core.api.Assertions.assertThat(updateuser.getLastName()).isEqualTo("Rahmatullah");
        System.out.println("Updated");

        }


}
