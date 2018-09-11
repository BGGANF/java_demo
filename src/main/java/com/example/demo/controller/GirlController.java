package com.example.demo.controller;
import com.example.demo.dao.*;
import com.example.demo.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<GirlEntity> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "girl")
    public GirlEntity add(
            @RequestParam("cupSize") String cupSize,
            @RequestParam("age") Integer age
    ){
        GirlEntity girl = new GirlEntity();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);

    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        GirlEntity girl = new GirlEntity();
        girl.setId(id);

        girlRepository.delete(girl);
    }

    /**
     * 根据ID查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public GirlEntity girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 修改一个女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public GirlEntity updateByID(
            @PathVariable("id") Integer id,
            @RequestParam("cupSize") String cupSize,
            @RequestParam("age") Integer age
    ){
        GirlEntity girl = new GirlEntity();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }
}
