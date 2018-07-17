package com.xqq.three.Aspect;

import com.xqq.three.annotation.LogRecord;
import com.xqq.three.entity.LogEntity;
import com.xqq.three.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author xuqiangqiang
 * @Date: 2018/7/10 10:17
 * @Description:
 */
@Aspect
@Component
@Order(2)
public class LogAspect {
    @Autowired
    private LogService logService;


    @Pointcut("@annotation(com.xqq.three.annotation.LogRecord)")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LogEntity logEntity = new LogEntity();
        logEntity.setName("admin");
        logEntity.setCreateTime(new Date());
        //设置IP
        logEntity.setIp(request.getRemoteAddr());
        //获取抽象方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //获取当前类对象
        Class<?> clazz = joinPoint.getTarget().getClass();
        //获取当前类有LogRecord注解的
        method = clazz.getMethod(method.getName(), method.getParameterTypes());
        LogRecord annotation = method.getAnnotation(LogRecord.class);
        logEntity.setContent(annotation.value());
        logEntity.setType(annotation.type());
        logService.save(logEntity);
    }

    /**
     * 处理请求结束日志记录
     *
     * @param object
     * @throws Throwable
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) throws Throwable {

    }
}
