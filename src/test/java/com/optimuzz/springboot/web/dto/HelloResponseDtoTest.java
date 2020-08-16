package com.optimuzz.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void test_getName() throws Exception {
        // arrange
        String name = "test";
        int amount = 10000;
        // execute
        var actual = new HelloResponseDto(name, amount);
        // assert
        assertThat(actual.getName()).isEqualTo(name); // assertThat : support method chaining
        assertThat(actual.getAmount()).isEqualTo(amount);
    }
}