package com.xqq.three.service;

import com.xqq.three.dao.LogDao;
import com.xqq.three.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author xuqiangqiang
 * @Date: 2018/7/9 15:40
 * @Description:
 */
@Service
public class LogService {
    @Autowired
    private LogDao logDao;
    public void save(LogEntity entity)  {
        logDao.save(entity);
    }
}
