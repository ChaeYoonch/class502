package exam02;

import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("년 월 입력:");
            String input = sc.nextLine(); // 2024 5

            if (input.equals("exit")) {
                System.out.println("종료 합니다.");
                break;
            }

            try {
                String[] data = input.split("\\s+");
                int year = Integer.parseInt(data[0]);
                int month = Integer.parseInt(data[1]);

                System.out.printf("---- %d년 %d월 ----%n", year, month); // 매개변수 = year, month 사용하면 됨!
                System.out.println("일  월  화  수  목  금  토");

            } catch (Exception e) { // 숫자 형식 오류가 발생한 경우
                System.out.println("입력 형식이 잘못되었습니다. 입력 예) 2024 5");
            }
        }
    }

    public static Object getCalendar(int year, int month) {
        /**
         * 1. 매월의 1일이 어떤 요일에 시작하는지 (월 ~ 일)
         * 2. 매월의 종료일이 무엇인지 (28, 29, 30, 31)
         */
        return null;
    }
}
