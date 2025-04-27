package springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* springaopdemo.service.*.*(..))")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        logger.info("Before executing service method: {} with arguments: {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* springaopdemo.service.*.*(..))", returning = "result")
    public void logAfterServiceMethod(JoinPoint joinPoint, Object result) {
        logger.info("After executing service method: {} with result: {}",
                joinPoint.getSignature().toShortString(),
                result);
    }

    @AfterThrowing(pointcut = "execution(* springaopdemo.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.error("Exception in service method: {} with message: {}",
                joinPoint.getSignature().toShortString(),
                ex.getMessage());
    }
}
