package exam05;

public abstract class Calculator { // 불완전한 클래스 -> 객체 되지 않음 => 정의 후 : 됨 | 객체가 됨 (힙에 공간O)
    int num = 10;

    public abstract int add(int num1, int num2);
} // public int add(int num1, int num2); 추상메서드 | 결정되지 않은 | 접근제어자, 반환값, 메서드만 정의
