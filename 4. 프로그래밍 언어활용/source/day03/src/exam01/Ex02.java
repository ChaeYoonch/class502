package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule(2024, 4, 17);
        s1.showDate();

        Schedule s2 = new Schedule();
        s2.showDate(); // 정수의 기본값 0 으로 결과 도출
    }
}
