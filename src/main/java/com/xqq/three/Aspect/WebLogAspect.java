package com.xqq.three.Aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @author xuqiangqiang
 * @Date: 2018/7/9 14:48
 * @Description:
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {
    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    /**
     * 记录开始请求的时间
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.xqq.three.controller..*Controller..*(..)))")
    public void webLog() {

    }


    /**
     * 在处理请求前记录
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("URL :" + request.getRequestURI());
        logger.info("IP :"+request.getRemoteAddr());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturing(Object object) throws Throwable{
        logger.info("RESPONSE : " + JSONObject.toJSONString(object));
        logger.info("HANDLE_TIME : " + (System.currentTimeMillis() - startTime.get()));
        startTime.remove();
    }

}
