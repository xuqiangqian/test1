package com.xqq.three.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/13 14:12
 * @Description:
 */
@Controller
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    @ResponseBody
    public String test(String str) {
        logger.info("test mesg");
        return "test" + str;
    }

//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "value1");
//        map.put("", "");
//        map.put("2", "value2");
//        System.out.println("通过map.keySet来遍历key和value");
//        for (String key : map.keySet()) {
//            System.out.println("key= " + key + " and value=" + map.get(key));
//        }
//
//        System.out.println("通过map.entrySet来遍历key和value");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("key= " + entry.getKey() + " and value =" + entry.getValue());
//        }
//    }

}
