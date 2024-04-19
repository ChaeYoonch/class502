package exam02;

public class B extends A { // B가 A를 상속
    int numB = 20;

    public B() {
        super(); // 상위 클래스의 기본생성자 -> A 클래스에 정의된 A();
        System.out.println("B 생성자!");
    } // public B() -> 기본생성자가 존재 | 기본적으로 super(); 추가되어 있음
}
