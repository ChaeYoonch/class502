package exam11;

public class Outer {

    static class Inner {
        public void method() {
            System.out.println("정적 내부 클래스에서 호출!");
        }
    }
}
