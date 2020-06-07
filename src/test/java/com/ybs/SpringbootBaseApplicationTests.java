package com.ybs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybs.common.util.IdWorker;
import com.ybs.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class SpringbootBaseApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IdWorker idWorker;

    @Test
    void contextLoads() {
    }

    //    @Test
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


    //使用mockmvc
    @Autowired
    MockMvc mockMvc;


    //测试方法
    @Test
    public void saveUser() throws Exception {

        String user = "{\"id\":12,\"username\":\"魏元宝\",\"nickname\":\"元宝dsfdfsfdssdf森3\",\"password\":\"mima\",\"email\":\"ybsdeyx@foxmail.com\"}\n";

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post("/user/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(user);
        ResultActions result = mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
        result.andReturn().getResponse().setCharacterEncoding("UTF-8");
        log.info(result.andReturn().getResponse().getContentAsString());
    }

}
