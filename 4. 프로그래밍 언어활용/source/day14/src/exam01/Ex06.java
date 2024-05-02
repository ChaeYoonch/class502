package exam01;

import java.util.function.IntPredicate;

public class Ex06 {
    public static void main(String[] args) {
        IntPredicate cond1 = x -> x >= 10; // x가 들어왔을 때, x가 10보다 큰가
        IntPredicate cond2 = x -> x <= 100; // x가 들어왔을 때, x가 100보다 작은가
        IntPredicate cond3 = cond1.and(cond2); // x >= 10 && x <= 100 x가 10보다 크고 100보다 작음 조건 2개 결합
        IntPredicate cond4 = cond2.negate(); // x > 100 | negate = 부정, !과 동일

        System.out.println(cond3.test(50));
        System.out.println(cond3.test(150));
        System.out.println(cond4.test(150));
        // System.out.println(cond1.test(20)); // true -> 20 > 10
    }
}
