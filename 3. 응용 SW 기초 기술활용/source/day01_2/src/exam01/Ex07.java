package exam01;

public class Ex07 {
    public static void main(String[] args) {
        long num1 = 10_000_000_000L; // int (4byte)

        byte num2 = 100; // int -> byte

        // float num3 = 100.123; // double (8byte) -> float
        float num4 = 100.123F; // F -> 처음부터 4바이트 float 로 공간 할당
    }
}
