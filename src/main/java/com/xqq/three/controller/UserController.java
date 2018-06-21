package com.xqq.three.controller;

import com.xqq.three.JPA.UserJPA;
import com.xqq.three.entity.UserEntity;
import com.xqq.three.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/12 14:33
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userService.list();
    }


//    @RequestMapping(value = "/save",method = RequestMethod.GET)
//    public UserEntity save(UserEntity entity) {
//        return userJPA.save(entity);
//    }
//
//    @RequestMapping(value = "/delete",method = RequestMethod.GET)
//    public List<UserEntity> delete(Long id) {
//        userJPA.deleteById(id);
//        return  userJPA.findAll();
//    }
}
