package com.xqq.three.dao;

import com.xqq.three.entity.LogEntity;
import org.springframework.stereotype.Repository;

/**
 * @author xuqiangqiang
 * @Date: 2018/7/10 09:45
 * @Description:
 */
@Repository
public interface LogDao {
    void save(LogEntity logEntity);
}
