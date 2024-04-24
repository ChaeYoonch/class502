package exam03;

public class Ex09 { // 중간에 받은 클래스라고 가정! -> 동적 로딩 = forName()
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("exam03.Person");
        // 동적으로 로딩 | throws ClassNotFoundException => 클래스 -> 메모리 영역
    }
}
