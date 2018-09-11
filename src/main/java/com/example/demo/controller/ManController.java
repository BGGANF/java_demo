package com.example.demo.controller;
import com.example.demo.dao.*;
import com.example.demo.domain.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ManController {

    @Autowired
    public ManRepository manRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/mans")
    public List<ManEntity> gitList(){
        List list = new ArrayList();
        list  = manRepository.findAll();

        return list;
    }

    @GetMapping("/test")
    public ManEntity test(){
        ManEntity man = new ManEntity();
        man.setId(222);
        man.setAge(77);
        man.setName("张珊");

        //创建JSONObject对象
        JSONObject json = new JSONObject();
        //向json中添加数据
        json.put("username", "wanglihong");
        json.put("height", 12.5);
        json.put("age", 24);
        //创建JSONArray数组，并将json添加到数组
        JSONArray array = new JSONArray();
        array.add(json);

        //转换为字符串
        String jsonStr = array.toString();
        System.out.println(jsonStr);

        return man;
    }

    @GetMapping("/testRedis")
    public Object testRedis(){
        ValueOperations<String,String> value = stringRedisTemplate.opsForValue();
        value.set("mykey4","random1="+Math.random());

        System.out.println(value.get("mykey4"));

        Object man = value.get("mykey4");
        return man;
    }
}
