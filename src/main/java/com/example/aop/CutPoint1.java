package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class CutPoint1 {

    @Around("execution(* com.example.service.*.*(..))")
    public Object cut01(ProceedingJoinPoint pjp) throws Throwable {
        long t1=System.currentTimeMillis();
        System.out.println(pjp.getSignature()+" is starting to proceeding!");
        Object val=pjp.proceed();
        long t2=System.currentTimeMillis();
        System.out.println(pjp.getSignature()+" return val="+val.toString());
        System.out.println(pjp.getSignature()+" is done! costs "+(t2-t1)+"ms");
        return val;
    }


}
