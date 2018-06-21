package com.xqq.three.JPA;

import com.xqq.three.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/12 14:41
 * @Description:
 */
public interface UserJPA extends JpaSpecificationExecutor<UserEntity>, Serializable, JpaRepository<UserEntity, Long> {
    @Query(value = "select * from t_user where t_name =?1 ", nativeQuery = true)
    UserEntity findByName(String name);
}