package exam01;

import java.util.function.Function;

public class Ex05 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = s -> s.length(); // (1)
        Function<Integer, Integer> func2 = x -> x * x; // (2)
        Function<String, Integer> func3 = func1.andThen(func2);
        Function<String, Integer> func4 = func2.compose(func1); // func1 -> func2

        int num = func3.apply("가나다"); // 가나다 -> 3 (1) -> 9 (2)
        int num2 = func4.apply("가나다");
        System.out.println(num);
        System.out.println(num2);
        // int len = func1.apply("가나다");
        // System.out.println(len);
    }
}
