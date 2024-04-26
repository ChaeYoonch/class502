package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Transportation trans = Transportation.BUS;
        String str = trans.name(); // 상수명 그대로 문자열로 바꿔줌 | trans.toString() 과 동일한 기능
        System.out.println(str);

        int ordinal = trans.ordinal(); // 상수의 위치 번호
        System.out.println(ordinal);
    }
}
