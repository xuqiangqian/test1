package com.xqq.three.controller;

import com.xqq.three.JPA.UserJPA;
import com.xqq.three.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/12 16:23
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {
    private Logger logger=LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserJPA userJPA;


    @RequestMapping(value = "/login",produces = "text/plain;charset=UTF-8")
    public String login(UserEntity user, HttpServletRequest request) {
        boolean flag = true;
        String result = "登陆成功";
        UserEntity userEntity = userJPA.findByName(user.getName());
        //用户不存在
        if (userEntity == null) {
            flag = false;
            result = "用户不存在";
        }else if( !userEntity.getPassword().equals(user.getPassword())){
            flag = false;
            result = "密码错误";
        }
        //登陆成功
        if (flag) {
            //将用户写入session
            request.getSession().setAttribute("_session_user", userEntity);
        }
        logger.info("登陆成功");
        return result;
    }
}
