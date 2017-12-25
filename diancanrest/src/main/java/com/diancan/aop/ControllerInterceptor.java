package com.diancan.aop;

import com.fasterxml.jackson.core.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Intercept all controller requests
 */
@Aspect
@Component
public class ControllerInterceptor {

    private static  final Logger logger = LogManager.getLogger(ControllerInterceptor.class);

    @Value("${spring.profiles}")
    String env;


    /**
     * 定义拦截规则
     */
    @Pointcut("execution(* com.diancan.web.resto.controllers..* (..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodePointcut() {}

    @Around("controllerMethodePointcut()") //也可以把拦截规则定义在这里
    public  Object Interceptor(ProceedingJoinPoint pjp) {

        long beginTime =System.currentTimeMillis();
        MethodSignature signature =(MethodSignature) pjp.getSignature();

        Method method =signature.getMethod(); //拦截方法

        String methodName =method.getName();//拦截方法名

        Set<Object> allParames = new LinkedHashSet<>(); //保存所有的请求参数

        logger.info("request start-method:%s",methodName);

        Object result =null;

        Object[] args = pjp.getArgs();

        for(Object arg: args) {
            if(arg instanceof Map<?,?>){
                // 提取方法中的map 参数
                @SuppressWarnings("unchecked")
                Map<String,Object> map = (Map<String, Object>) arg;
                allParames.add(arg);
            }else if(arg instanceof HttpServletRequest) {

                HttpServletRequest request =(HttpServletRequest) arg;
                // get query string or post form data
                Map<String,String[]> reqParams =request.getParameterMap();

                if(reqParams!=null && reqParams.size() >0) {
                    allParames.add(reqParams);
                }
            }else if(arg instanceof HttpServletResponse) {
                //do nothing
            }else {
                allParames.add(arg);
            }

            try {
                if(result==null) {
                    // 正常情况下,继续执行拦截方法
                    result =pjp.proceed();
                }
            }catch (Throwable e) {
                logger.error("exception:",e.getLocalizedMessage());
            }

            long costMs =System.currentTimeMillis()-beginTime;
            logger.info("%/s request end,cost %/s ms",methodName,costMs);
        }
        return  result;
    }

}
