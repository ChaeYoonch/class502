package exam01;

public class Ex04 {
    public static void main(String[] args) {
        A a = new A() {
            public void method() {
                System.out.println("재정의된 메서드!");
            }
        }; // A a = new A();일반적인 객체 | A a = new A() {}; -> 상속을 하지 않고도 생성 과정 중에 재정의 가능!

        a.method(); // 제정의된 메서드 가 호출됨!
    }
}
