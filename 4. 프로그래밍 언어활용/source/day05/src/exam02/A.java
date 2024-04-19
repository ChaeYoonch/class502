package exam02; // B가 A를 상속받는 관계

public class A {
    int numA = 10;

    public A() {
        super(); // 상위 클래스 생성자
        System.out.println("A 생성자!");
    } // 클래스명과 동일한 명칭의 기본생성자 존재
}
