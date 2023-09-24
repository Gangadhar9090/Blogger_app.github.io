package com.myblog.blogapp.repository;

import com.myblog.blogapp.entities.Role;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;
    @Test
    void findByName(){
        Role role = new Role();
        Optional<Role> exist = roleRepository.findByName(role.getName());
        if(!exist.isPresent()){
            roleRepository.save(role);
        }
        Optional<Role> found = roleRepository.findByName("ROLE_ADMIN");
       assertThat(found.isPresent()).isTrue();
       assertThat(found.get().getName()).isEqualTo("ROLE_ADMIN");



    }

}