package exam01;

public class ImplCalculator implements Calculator {

    @Override
    public long factorial(long num) {
        long result = 1L;

        for (long i = 1L; i <= num; i++) { // 반복문을 이용한 팩토리얼 연산
            result *= i;
        }

        return 0;
    }
}