package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
public class HelloController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String say(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {
        return "Hello spring boot: " + id;
    }

    @GetMapping(value = "/hello/test1")
    public String test1() {
        int [] data = new int[]{1,2,3,45,6};

        //普通for循环案例
        for (int i = 0 ;i<data.length; i++){
            System.out.println(data[i]);
        }

        System.out.println("---------------");

        //foreach 案例
        for (int temp: data) { //自动循环，将data数据每一个内容交给temp
            System.out.println(temp);
        }

        return "一维数组";
    }

    @GetMapping(value = "/hello/test2")
    public String test2() {
        int [][] data = new int[][]{
                {1,2,3,4},
                {3,2,1},
                {6,7,8}
        };

        //普通for循环案例
        for (int x = 0 ;x < data.length; x++){
            for (int y = 0; y < data[x].length; y++){
                System.out.println("data[" + x + "][" + y + "]=" + data[x][y]);
            }
            System.out.println();
        }

        System.out.println("---------------");

        //foreach 案例
        for (int temp[]:data) {
            for (int num:temp){
                System.out.println(num);
            }
            System.out.println();
        }

        return "二维数组";
    }

    @GetMapping(value = "/hello/test3")
    public String test3(){
        Person [] per = new Person[]{
                new Person("张三",20),
                new Person("李四",25),
                new Person("王五",30),
        };

        //普通for循环案例
        for(int x = 0; x < per.length; x ++){
            System.out.println(per[x].getInfo());
        }

        //foreach 案例
        for(Person temp:per ){
            System.out.println(temp.getName());
            System.out.println(temp.getAge());
        }

        return "对象数组";
    }

    @GetMapping(value = "/hello/test4")
    public String test4(){
        Integer [] num = fun(1,2,4);
        for(int temp : num){
            System.out.println(temp);
        }

        System.out.println("---------------");

        String [] str = fun("a","b","c");
        for(String temp : str){
            System.out.println(temp);
        }

        return "泛型方法测试";
    }

    public <T> T[] fun(T ... args){
        return args;
    }
}

class Person{
    private String name;

    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getInfo(){
        return "姓名：" + this.name + "、年龄：" + this.age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}
