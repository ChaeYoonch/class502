package exam10;

public class Outer {

    class Inner { // 인스턴스 내부 클래스
        public void method() {
            System.out.println("인스턴스 내부 클래스에서 호출");
        }
    }
}
