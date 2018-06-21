package com.xqq.three.service;

import com.xqq.three.JPA.UserJPA;
import com.xqq.three.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/19 13:39
 * @Description:
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {
    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表
     * @return
     */
    @Cacheable
    public List<UserEntity> list() {
        return userJPA.findAll();
    }
}
