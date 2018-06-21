package com.xqq.three.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/21 15:26
 * @Description:
 */
@RestController
public class CorsController {
    @RequestMapping(value = "/cors")
    public String corsIndex() {
        return "this is cors info";
    }
}
