package com.ybs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybs.common.util.IdWorker;
import com.ybs.controller.UserController;
import com.ybs.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest
@TestExecutionListeners({MockitoTestExecutionListener.class})
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


    //mock对象
    private static MockMvc mockMvc;

    //在所有测试方法执行之前进行mock对象初始化
    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    //测试方法
    @Test
    public void saveUser() throws Exception {

        String user = "{\"id\":12,\"username\":\"魏元宝\",\"nickname\":\"元宝dsfdfsfdssdf森3\",\"password\":\"mima\",\"email\":\"ybsdeyx@foxmail.com\"}\n";
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/user/add")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(user)

        )
                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
//                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value("魏元宝"))
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());

    }

}
