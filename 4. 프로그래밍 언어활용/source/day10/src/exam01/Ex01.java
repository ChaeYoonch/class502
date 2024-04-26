package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Transportation tran1 = Transportation.BUS; // 상수는 1개만 존재
        Transportation tran2 = Transportation.BUS;

        System.out.println(tran1 == tran2);
    }
}
