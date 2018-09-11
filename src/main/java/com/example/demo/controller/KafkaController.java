package com.example.demo.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class KafkaController {

    /**
     * 注入kafkaTemplate
     */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 发送消息的方法
     *
     * @param key  推送数据的key
     * @param data 推送数据的data
     */
    private void send(String key, String data) {
        kafkaTemplate.send("test-1", key, data);
    }

    @RequestMapping("/kafka")
    public String testKafka() {
        int iMax = 6;
        for (int i = 1; i < iMax; i++) {
            send("key" + i, "data" + i);
        }
        return "success";
    }

    /**
     * 使用日志打印消息
     */
    private static Logger logger = LoggerFactory.getLogger(KafkaController.class);

//    @KafkaListener(topics = "test-1")
//    public void receive(ConsumerRecord<?, ?> consumer) {
//        logger.info("topic:{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
//    }


}