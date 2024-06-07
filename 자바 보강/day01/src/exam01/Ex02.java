package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int y = calc(3); // x = 힌트 | 여기의 x: 3값이 아래 int x 에 대입됨
        System.out.println(y);
    }

    public static int calc(int x) { // 반환값 자료형 = 7 -> 정수 int (1) 함수명 calc (2) 매개변수 정수형 int (3)

        int y = x * 2 + 1; // 실행될 코드

        return y; // 반환값 = y
    }
}
