package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int num = 10;
        boolean result = ++num > 10 && (num = num + 10)> 15; // num++ : false -> && ~ 15; 연산 X
        System.out.println(result);
        System.out.println(num);
        boolean result2 = !result; // true -> false 로 변경 | 부정 연산
        System.out.println(result2);
    }
}
