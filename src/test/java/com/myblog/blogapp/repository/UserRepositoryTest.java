package com.myblog.blogapp.repository;

import com.myblog.blogapp.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsernameOrEmail() {
        User user = new User();

        Optional<User> existingUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (!existingUser.isPresent()) {
            userRepository.save(user);
        }

        Optional<User> foundUser = userRepository.findByUsernameOrEmail("Gangadhar@1999", "ganguli1433@gmail.com");
       // Optional<User> notFoundUser = userRepository.findByUsernameOrEmail("nonexistentuser", "invalid@example.com");

        assertThat(foundUser.isPresent()).isTrue();
        assertThat(foundUser.get().getUsername()).isEqualTo("Gangadhar@1998");
        assertThat(foundUser.get().getEmail()).isEqualTo("ganguli1433@gmail.com");

       // assertThat(notFoundUser.isPresent()).isFalse();
    }
}