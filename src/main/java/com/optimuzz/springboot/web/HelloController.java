package com.optimuzz.springboot.web;

import com.optimuzz.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Springboot controller for Json response.
 * (old style : define @ResponseBody for every methods.)
 *
 */
@RestController // make controller to return json
public class HelloController {

    /**
     * GetMapping => old style : @RequestMapping(method = RequestMethod.GET)
     *
     * @return {@link String}
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * this endpoint is requested with named 'name' and 'amount' variables.
     *
     * @param name {@link String}
     * @param amount {@link int}
     * @return {@link HelloResponseDto}
     */
    @GetMapping("hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
