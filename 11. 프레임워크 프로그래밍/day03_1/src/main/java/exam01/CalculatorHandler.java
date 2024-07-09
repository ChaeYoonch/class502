package exam01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler implements InvocationHandler { // InvocationHandler 구현 예정

    private Object obj;

    public  CalculatorHandler(Object obj) {
        this.obj = obj; // 매개변수로 실제 obj 즉, 생성자 매개변수로 넘겨줌
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        // System.out.println("유입!");
        long stime = System.nanoTime(); // 추가 기능 - 공통 기능, 공통 관심사
        try {
            Object result = method.invoke(obj, args); // Calculator factorial 호출 => 핵심 기능을 대신 수행

            return result;
        } finally {
            long etime = System.nanoTime(); // 추가 기능 - 공통 기능, 공통 관심사
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}