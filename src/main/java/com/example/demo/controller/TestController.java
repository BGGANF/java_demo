package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.properties.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class TestController {

    @Autowired
    private testProperties testProperties;

//    @Value("${spring.myProps.name}")
//    private String name;

    @GetMapping("/getprop")
    public String getprop(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println("simpleProp:" + testProperties.getSimpleProp());
            System.out.println("getArrayProps:" +objectMapper.writeValueAsString(testProperties.getArrayProps()));
            System.out.println("getListProp1:" +objectMapper.writeValueAsString(testProperties.getListProp1()));
            System.out.println("getListProp2:" +objectMapper.writeValueAsString(testProperties.getListProp2()));
        }catch (JsonGenerationException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }

        return "TestController";
    }

    @RequestMapping(value="/test/map", method = RequestMethod.GET)
    public void map(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value2");

        //keySet遍历
        for(String key : map.keySet()){
//            System.out.println(key + ": "+map.get(key));
        }

        //使用entrySet遍历
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @GetMapping("/test/date")
    public String test(){

//        Calendar todayStart = Calendar.getInstance();
//        todayStart.set(Calendar.HOUR_OF_DAY, 0);
//        todayStart.set(Calendar.MINUTE, 0);
//        todayStart.set(Calendar.SECOND, 0);
//        todayStart.set(Calendar.MILLISECOND, 0);
//        System.out.println(todayStart.getTime());

        ZonedDateTime nowTime = Instant.now().atZone(ZoneId.systemDefault());
        long seconds  = nowTime.truncatedTo(ChronoUnit.MINUTES).toEpochSecond();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        Long todayTime = startOfDay.toEpochSecond(ZoneOffset.of("+8"));

        Long s = (System.currentTimeMillis()/1000 - todayTime) /  60 ;

        System.out.println(s);

        return "a";

//        ZonedDateTime nowTime = Instant.now().atZone(ZoneId.systemDefault());
//        long seconds  = nowTime.truncatedTo(ChronoUnit.MINUTES).toEpochSecond();
//        ZonedDateTime dateTime = Instant.ofEpochSecond(seconds).atZone(ZoneId.systemDefault());
//        seconds = dateTime.truncatedTo(ChronoUnit.MINUTES).toEpochSecond();
    }
}