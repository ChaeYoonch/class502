package exam13;

public class Ex02 {
    public static void main(String[] args) { // 지역 O
        Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        }; // 객체가 됨!

        int result = cal.add(10, 20);
        System.out.println(result);
    }
} // 직접 정의하는 것 보다 인터페이스로 정의하는 경우 多
