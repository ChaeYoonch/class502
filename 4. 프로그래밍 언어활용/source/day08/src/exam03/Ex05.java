package exam03;

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 100; // 객체
        Integer num2 = Integer.valueOf(200); // 객체 형태의 참조형 | 원칙 : 객체끼리는 연산 불가!!

        int result1 = num1 + num2; //  wrapper 된 기본값 200을 num2.intValue() 로 밖으로 꺼냄 = 언박싱 |
                                  // 컴파일러가 intValue() -> 정수형으로 기본 변환
        System.out.println(result1);

        Integer num3 = Integer.valueOf(100);
        Integer num4 = Integer.valueOf(200);

        int result2 = num3.intValue() + num4.intValue();
        System.out.println(result2); // 객체 안의 값을 꺼내는 intValue()
    }
}
