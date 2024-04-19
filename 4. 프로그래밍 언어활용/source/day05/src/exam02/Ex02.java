package exam02;

public class Ex02 {
    public static void main(String[] args) {
        // C c = new C();
        // A a = c; // A 라는 객체의 내용물 = C 라는 클래스 객체 내용물 | C 자료형 -> A 자료형으로 형변환 발생 | 본질은 C에서 연결된 것
        // B b = c; // B 가 정의하는 만큼만 사용 가능 | 본질은 C에서 연결된 것
        // b.numB & b.numA
        // a.numA // 내용물이 A로 한정됨

        A a = new C(); // C c = new C(); + A a = c; 과 동일한 내용!
    }
}
