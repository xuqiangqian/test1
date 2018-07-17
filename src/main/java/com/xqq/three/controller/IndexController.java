package com.xqq.three.controller;

import com.xqq.three.annotation.LogRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author xuqiangqiang
 * @Date: 2018/6/12 17:05
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 初始化登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
    public String login_view() {
        return "login";
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        logger.info("这是首页");
        return "index";
    }


}
