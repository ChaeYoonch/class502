package exam02;

public class Ex03 {
    public static void main(String[] args) {
        Transportation trans = Transportation.BUS; // 정적 상수 객체
        int fare = trans.getFare();
        System.out.println(fare);
    }
}
