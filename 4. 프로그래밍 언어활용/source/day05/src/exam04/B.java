package exam04;

public class B extends A {
    int numB = 20;

    public B() {
        super(); // A 클래스의 A()가 호출됨
        System.out.println("B 생성자!");
    }
}
