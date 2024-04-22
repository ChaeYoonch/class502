package exam01;

public class SimpleCalculator extends Calculator {
    // 상속을 받아도 불완전 | 추상클래스로 만들기 (abstract) or 구현하지 않은 메서드 구현 (add)
    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
