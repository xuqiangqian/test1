package com.xqq.three.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/12 14:35
 * @Description:
 */
@Entity
@Table(name = "t_user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;
    @Column(name = "t_name")
    private String name;
    @Column(name = "t_age")
    private Integer age;
    @Column(name = "t_address")
    private String address;
    @Column(name="t_pwd")
    private String password;

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
