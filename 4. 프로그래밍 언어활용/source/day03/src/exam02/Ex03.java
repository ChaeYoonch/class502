package exam02;

public class Ex03 {
    public static void main(String[] args) {
        int result1 = add(10,20);
        System.out.println(result1);

        int result2 = add(30, 40);
        System.out.println(result2);
    }

    public static int add(int num1, int num2) {
        return num1 + num2; // 수행 절차는 바뀌지 않음
    } // static -> 정적인 것만 접근 가능 | 객체와 상관 X | static 없으면 접근 불가능!
}
