package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redis")
    public Object redis(){
        ValueOperations<String,String> value = stringRedisTemplate.opsForValue();
        value.set("key","random1="+Math.random());

        System.out.println(value.get("key"));

        Object result = value.get("key");
        return result;
    }
}
