package com.admin.user;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PasswordEncoderTest {

    @Test
    public void testEncodePassword(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "asdf";
        String encodePassword = passwordEncoder.encode(rawPassword);

        System.out.println(encodePassword);

        boolean matches = passwordEncoder.matches(rawPassword,encodePassword);

        assertThat(matches).isTrue();
    }
}
