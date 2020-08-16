package com.optimuzz.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * RunWith(SpringRunner.class) : make bridge spring to JUnit
 * WebMvcTest : need for qualifying bean of MockMvc
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // start point of Spring MVC test (GET, POST, etc)

    @Test
    public void test_Hello_returnHelloString() throws Exception {
        String expected = "hello";
        mvc.perform(get("/hello"))
                //@formatter:off
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
                //@formatter:on
    }

    /**
     * param() : set request parameter. only permitted String values.
     * jsonPath() : check a field value of json formatted response.
     * ("$.name", "$.amount" : field names)
     */
    @Test
    public void test_HelloDto_returnResponseDto() throws Exception {
        String name = "name";
        int amount = 1000;
        mvc.perform(get("/hello/dto")
                //@formatter:off
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
                //@formatter:off
    }
}