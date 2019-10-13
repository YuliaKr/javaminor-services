package com.javaminor.three_layers_model.config.aspects;

import com.javaminor.three_layers_model.services.ILogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class LogsDBAspect {
    private final ILogService logService;

    @Autowired
    public LogsDBAspect(ILogService logService) {
        this.logService = logService;
    }


    @Around("execution(* com.javaminor.three_layers_model.repositories..*(..))")
    public void doAroundDataBaseExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("X-Trace-Database-Time");
        if (header != null && !header.isEmpty()) {
            var signature = joinPoint.getSignature();
            logService.Log(start, System.currentTimeMillis(), signature.getDeclaringTypeName(), signature.getName());
        }
    }

    @Around("execution(* com.javaminor.three_layers_model.controllers..*(..))")
    public void doAroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        var signature = joinPoint.getSignature();
        logService.Log(start, System.currentTimeMillis(), signature.getDeclaringTypeName(), signature.getName());
    }
}
