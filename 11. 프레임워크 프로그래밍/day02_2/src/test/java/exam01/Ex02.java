package exam01;

import exam02.Calculator;
import exam02.CalculatorHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Ex02 {

    @Test
    void test1() {
        Object obj = Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[] { Calculator.class },
                new CalculatorHandler(new RecCalculator())
        ); // 매개변수 1 = 클래스 Class, 매개변수 2 = Class[], 매개변수 3 = CalculatorHandler

        Calculator cal = (Calculator) obj;
        cal.factorial(10L);
    }
}