package com.example.newboot.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAcpect {
    /**
     * before(前置通知)： 在方法开始执行前执行
     * after(后置通知)： 在方法执行后执行
     * afterReturning(返回后通知)： 在方法返回后执行
     * afterThrowing(异常通知)： 在抛出异常时执行
     * around(环绕通知)： 在方法执行前和执行后都会执行
     * 执行顺序
     * around > before > around > after > afterReturning
     */

    private static final Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);

    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
//    @Pointcut("execution(public * com.example.newboot.aop.*.*(..))")
    @Pointcut("execution(public * com.example.newboot.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void webLog() {
    }

    /**
     * 前置通知：在连接点之前执行的通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("********************aop调用了开始*******************");
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("********************aop调用了结束*******************");
    }

}
