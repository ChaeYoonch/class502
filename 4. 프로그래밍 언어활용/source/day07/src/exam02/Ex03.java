package exam02;

public class Ex03 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 2;
            int result = num1 / num2; // 예외 발생 시 = 오류 발생 시 기본 동작 => 프로그램이 중단됨 | ArithmeticException

            String str = null;
            System.out.println(str.toUpperCase()); // NullPointerException

            System.out.println(result);
        } catch (ArithmeticException | NullPointerException e) { // 처리가 동일한 경우
            e.printStackTrace();
        }

        System.out.println("매우 중요한 실행 코드 ..."); // try ~ catch 사용 후 실행 O
    }
}
