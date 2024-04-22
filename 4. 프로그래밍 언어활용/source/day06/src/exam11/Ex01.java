package exam11;

public class Ex01 {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.method(); // 정적 인스턴스 자원 호출 X -> this 가 없으므로 => 객체와 상관 없기 때문
    }
}
