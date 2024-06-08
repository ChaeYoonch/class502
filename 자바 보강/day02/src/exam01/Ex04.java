package exam01;

public class Ex04 {
    public static void main(String[] args) {
        int result1 = add(10, 20); // 매개변수가 2개인 (1) 호출
        System.out.println(result1);
        int result2 = add(10, 20, 30); // 매개변수가 3개인 (2) 호출
        System.out.println(result2);
    }

    public static int add(int num1, int num2) { // 반환값 타입 int + 함수명 add + 매개변수 정의 num1, num2 함수의 시그니처
        return num1 + num2; // (1)
    }

    public static int add(int num1, int num2, int num3) {
        return num1 + num2 + num3; // (2)
    }
}
