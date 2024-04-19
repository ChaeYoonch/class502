package exam02;

public class C extends B {
    int numC = 30;

    public C() {
        super(); // this 와 동일 | B 클래스에 정의된 B();
        System.out.println("C 생성자!");
    }
} // 컴파일러 : 기본생성자 추가 + super
