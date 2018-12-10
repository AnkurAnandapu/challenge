package com.carfax.challenge;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@ActiveProfiles(value = "componentTest")
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = {ChallengeApplication.class, BaseComponentTest.class})
@Slf4j
public class BaseComponentTest {


    @Getter
    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testWhenContextLoads_ShouldStartSuccessfully() {
    }

}
