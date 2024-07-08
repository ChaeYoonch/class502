package exam01;

public class RecCalculator implements Calculator{

    @Override
    public long factorial(long num) { // 함수를 사용한 팩토리얼 계산
        if (num < 1L) {
            return 1L;
        }

        return num * factorial(num - 1L);
    }
}