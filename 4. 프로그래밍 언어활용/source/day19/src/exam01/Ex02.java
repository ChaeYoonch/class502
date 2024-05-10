package exam01;

public class Ex02 {
    public static void main(String[] args) {
        double num = 123.12345678;
        System.out.printf("%010.2f%n", num); // 앞의 정수는 10자리 , 소수점 뒤는 2자리까지만
        System.out.printf("%.2f%n", num); // 앞의 정수는 모두, 소수점 뒤는 2자리까지만
    }
}