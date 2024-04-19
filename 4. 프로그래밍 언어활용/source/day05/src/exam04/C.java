package exam04;

public class C extends B {
    int numC = 30;

    public C() {
        super(); // B 클래스의 B() 호출됨
        System.out.println("C 생성자!");
    }
}
