package exam01;

public class Ex04 { //exam01.Ex04 -> 실제 클래스명
    public static void main(String[] args) {
        int result1 = add(10, 20); // int add(int, int) => static int add(int num1, int num2) 호출
        System.out.println(result1);

        int result2 = add(10, 20, 30); // int add(int, int, int)
        System.out.println(result2);
    }

    static int add(int num1, int num2) {
        return num1 + num2;
    }

     static int add(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    } /* 매개변수 체크 -> 자료형만 확인 => 구분명이 바뀌면 오류 발생 X | 함수의 중복 정의 */

    static double add(double num1, double num2) {
        return num1 + num2;
    } // 메서드 오버로드 : 같은 명칭의 함수를 타입을 달리하여 정의하는 방식
}
