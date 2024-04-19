package exam05;

public class ComplexityCalculator extends Calculator {
    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }
} // 추상 클래스 = 설계도 (체계적으로 만들기 위해)의 틀 제공 (= 표준) -> 추상 메서드 이용
