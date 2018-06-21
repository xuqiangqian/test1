package com.xqq.three;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.*;

@SpringBootApplication
@EnableScheduling
public class ThreeApplication {

    public static void main(String[] args) {
        //原启动方式
        SpringApplication.run(ThreeApplication.class, args);

        /**
         *     隐藏banner启动方式
          */
//        SpringApplication springApplication=new SpringApplication(ThreeApplication.class);
//        //设置banner的模式为隐藏
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        //启动springboot的应用程序
//        springApplication.run(args);
    }
}
