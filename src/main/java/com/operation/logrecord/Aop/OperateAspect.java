package com.operation.logrecord.Aop;

import com.alibaba.fastjson.JSON;
import com.operation.logrecord.Annotations.RecordOperate;
import com.operation.logrecord.Convert.OrderConvert;
import com.operation.logrecord.Entity.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lzn
 * @date 2023/03/26 17:46
 * @description Aspect of the operate log, scan the class that use the @RecordOperate annotation and store them into the database asynchronously
 */
@Aspect
@Component
public class OperateAspect {

    @Pointcut("@annotation(com.operation.logrecord.Annotations.RecordOperate)")
    public void pointCut() {}

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        executor.submit(() -> {
            try {
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                RecordOperate recordOperate = signature.getMethod().getAnnotation(RecordOperate.class);
                Class<? extends OrderConvert> convert = recordOperate.convert();
                OrderConvert orderConvert = convert.newInstance();
                OperateLog operateLog = orderConvert.convert(joinPoint.getArgs()[0]);
                operateLog.setDesc(recordOperate.desc());
                operateLog.setResult(String.valueOf(result));
                System.out.println("insert operate log " + JSON.toJSONString(operateLog));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        return result;
    }
}
