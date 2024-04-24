package exam02;

public class Ex03 {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.printf("str 주소: %d%n", System.identityHashCode(str));

        str += "DEF";
        System.out.printf("str 주소: %d%n", System.identityHashCode(str)); // 주소가 바뀌어 있음

        str += "GHI";
        System.out.printf("str 주소: %d%n", System.identityHashCode(str)); // 주소가 바뀌어 있음

    }
}
