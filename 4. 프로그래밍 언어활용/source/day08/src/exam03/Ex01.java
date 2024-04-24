package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Integer num1 = new Integer(10);
        double num2 = num1.doubleValue(); // 정수가 되어야만 사용 가능

        String str = "1000"; // parseInt 로 변환 작업 필요
        int num3 = Integer.parseInt(str);

    }
}
