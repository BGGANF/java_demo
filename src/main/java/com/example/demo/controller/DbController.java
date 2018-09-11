package com.example.demo.controller;

import com.example.demo.domain.GirlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.ResultModel;

import java.util.List;

@RestController
public class DbController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/dbTest",method = RequestMethod.GET)
    public Object dbTest(){
        String sql = "select * from girl";
        BeanPropertyRowMapper<GirlEntity> rowMapper = new BeanPropertyRowMapper<>(GirlEntity.class);

        List<GirlEntity> girls = jdbcTemplate.query(sql, rowMapper);

        return ResultModel.success("查询成功",girls);
    }

    @RequestMapping(value = "/db/getByID/{id}")
    public Object getByID(@PathVariable("id") Integer id){
        String sql = "select * from girl where id =?";
        BeanPropertyRowMapper<GirlEntity> rowMapper = new BeanPropertyRowMapper<>(GirlEntity.class);

        List<GirlEntity> girl = jdbcTemplate.query(sql, rowMapper, id);

        return ResultModel.success("查询成功",girl);
    }
}
