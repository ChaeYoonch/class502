package exam01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Ex01 {

    @Test
    void test1() {
        Object obj = Proxy.newProxyInstance(
           Calculator.class.getClassLoader(), new Class[] {Calculator.class}, new CalculatorHandler(new RecCalculator())
        ); // ClassLoader, Class<?>[], InvocationHandler

        Calculator cal = (Calculator)obj;
        cal.factorial(10L); // CalculatorHandler 의 invoke 로 유입되어 호출됨
    }
}