package exam02;

public class Ex03 {
    public static void main(String[] args) {
        Schedule2 s1 = new Schedule2(2024, 5, 20); // 생성자 매개변수로 정의함
        System.out.println(s1); // s1.toString(); Schedule2{year=2024, month=5, day=20}

        Schedule2 s2 = new Schedule2();
        System.out.println(s2); // s2.toString(); Schedule2{year=2024, month=6, day=8}
    }
}
