package com.ybs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybs.common.util.IdWorker;
import com.ybs.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringbootBaseApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private IdWorker idWorker;

    @Test
    void contextLoads() {
    }

    @Test
    void testJackJson() throws JsonProcessingException {
        User user = new User();
        user.setId(idWorker.nextId());
        user.setDeleted(false);
        user.setCreated(LocalDateTime.now());
        user.setUsername("Paulson");
        user.setEmail("123@23.com");

        String user_json_str = objectMapper.writeValueAsString(user);
        System.out.println(user_json_str);


        User user1 = objectMapper.readValue(user_json_str, User.class);
        System.out.println(user1);


    }

}
