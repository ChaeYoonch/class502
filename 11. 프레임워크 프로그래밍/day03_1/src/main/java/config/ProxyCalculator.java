package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProxyCalculator {

    @Pointcut("execution(* exam01..*(..))") // 공통으로 적용될 수 있도록 하기 위해 범위 지정
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable { // 정해진 매개변수 ProceedingJoinPoint joinPoint

        System.out.println("유입!");

        Object result = joinPoint.proceed(); // 핵심 기능 대신 실행 - factorial

        return result;
    }
}