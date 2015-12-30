package ro.acasa.annonLogging.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ro.acasa.annonLogging.annotations.OnCall;
import ro.acasa.annonLogging.annotations.OnExit;

@Aspect
@Component
public class LoggingAspect {
    private final Log log = LogFactory.getLog(getClass());

    public LoggingAspect () {}

    @AfterReturning(value = "execution(* ro.acasa.annonLogging.service.*.*(..))")
    public void logMethodAccessAfter(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        OnExit annon = signature.getMethod().getAnnotation(OnExit.class);
        log.info(String.format(annon.message(), joinPoint.getArgs()));
    }

    @Before("execution(* ro.acasa.annonLogging.service.*.*(..))")
    public void logMethodAccessBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        OnCall annon = signature.getMethod().getAnnotation(OnCall.class);
        log.info(String.format(annon.message(), joinPoint.getArgs()));
    }
}
