package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class ProxyCalculator {

    @Pointcut("execution(* exam01..*(..))") // 공통으로 적용될 수 있도록 하기 위해 범위 지정
    public void publicTarget() {}

    // 시점 별로 호출 확인
    @Before("publicTarget()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before...");
    }

    @After("publicTarget()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After...");
    }

    @AfterReturning(value = "publicTarget()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
        System.out.println("AfterReturning : " + returnValue);
    }

    @AfterThrowing(value = "publicTarget()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("afterThrowing");
        e.printStackTrace();
    }

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable { // 정해진 매개변수 ProceedingJoinPoint joinPoint
        /*
        Signature sig = joinPoint.getSignature(); // 호출된 메서드 정의 정보
        System.out.println(sig.toLongString());

        Object[] args = joinPoint.getArgs(); // 인수 정보
        System.out.println(Arrays.toString(args));

        Object obj = joinPoint.getTarget(); // 호출한 메서드를 가지고 있는 객체
        System.out.println(obj.getClass());
        */
        long stime = System.nanoTime(); // 공통 기능
        boolean re = false;
        if (!re) {
            throw new RuntimeException("예외 테스트...");
        }
        try {
            // System.out.println("유입!");
            Object result = joinPoint.proceed(); // 핵심 기능 대신 실행 - factorial

            return result;
        } finally {
            long etime = System.nanoTime(); // 공통 기능
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}