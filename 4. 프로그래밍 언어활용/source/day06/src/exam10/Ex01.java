package exam10;

public class Ex01 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Outer.Inner 외부 클래스 객체 -> 인스턴스 자원과 비슷 => 접근 & 생성 가능
        inner.method();
    }
}
