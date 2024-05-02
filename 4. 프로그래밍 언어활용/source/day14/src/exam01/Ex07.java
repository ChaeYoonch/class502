package exam01;

import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class Ex07 {
    public static void main(String[] args) {
        ToIntFunction<String> func1 = s -> s.length(); // 들어올 땐 = 문자 | 나갈 땐 = 문자열
        ToIntFunction<String> func2 = String::length;

        BiPredicate<String, String> cond1 = (s1, s2) -> s1.equals(s2);// String -> 매개변수 | s1 & s2 비교
        BiPredicate<String, String> cond2 = String::equals; // 위의 것과 동일 | 메서드 참조 : 매개변수 형태 O, 순서 변경 X
    }
}
