package com.admin.user;

import com.admin.Repository.UserRepository;
import com.common.entity.Role;
import com.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private EntityManager em;

    @Test
    public void testCreateUser(){
        User user1 = new User("hyundho12@gmail.com","asdf","Kim","hyunho");
        Role roleAdmin = em.find(Role.class,1);

        user1.addRole(roleAdmin);

        User saveUser = repo.save(user1);

        assertThat(saveUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateUserWithTwoRoles(){
        User user2 = new User("user2@gmail.com","user2","Gom","poo");
        User user3 = new User("user3@gmail.com","user3","Kim","pooky");

        Role roleEditor = new Role(3L);
        Role roleAssistant = new Role(5L);

        user2.addRole(roleEditor);
        user2.addRole(roleAssistant);

        User saveUser = repo.save(user2);
    }


    @Test
    public void testGetUserEmail(){
        String email = "user2@gmail.com";
        User user = repo.getUserByEmail(email);

        assertThat(user).isNotNull();
    }
}
