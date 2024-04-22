package exam01;

public abstract class Calculator { // 정의 부분만 있는 것 -> 추상 클래스
    int num = 10; // 변수 대입

    public Calculator() {
        System.out.println("Calculator 생성자!");
    }

    public abstract int add(int num1, int num2);

    public final void commonMethod() { // final -> 재정의 못하게 막을 때 사용

    } // 추상 메서드만 정의하는 경우 -> 공통자원도 정의 가능
} // 객체 생성되지 X | 오류 = 통제 수단 => 객체가 되려면 반드시 구현해라~! | 원칙을 만드는 것 = 추상클래스
