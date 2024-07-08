package exam02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler implements InvocationHandler {

    private Object obj;

    public CalculatorHandler(Object obj) {
        this.obj = obj;
    }
    /**
     * @param method : 호출한 메서드의 정보 | 동적 메소드 호출 method.invoke(...)
     * args : 메서드 호출 시 넘겨준 값 (인수)
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(obj, args);

        return result;
    }
}