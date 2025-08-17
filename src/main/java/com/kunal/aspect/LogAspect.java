package com.kunal.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Kunal Raj S
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.kunal.service.impl.*.*(..))")
    public void serviceMethodExpression()
    {

    }
    @Before("serviceMethodExpression()")
    public void logBeforeAdvice(JoinPoint joinPoint)
    {
        LOGGER.info("Entered {} with arguments as {}",joinPoint.getSignature(),joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "serviceMethodExpression()",returning = "result")
    public void logAfterAdvice(JoinPoint joinPoint,Object result)
    {
        LOGGER.info("Completed {} with result",joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "serviceMethodExpression()",throwing = "exception")
    public void logAfterThrowingAdvice(JoinPoint joinPoint,Exception exception)
    {
        LOGGER.error("Completed {} with exception as {}",joinPoint.getSignature(),exception.getMessage());
    }
}
