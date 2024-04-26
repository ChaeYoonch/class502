package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Transportation trans = Transportation.BUS; // enum -> switch 구문에서 사용 多
        Enum<Transportation> trans2 = trans; // Enum 클래스의 상위클래스 O

        switch (trans) { // trans = Transportation | 자료명 붙이지 않고 상수명만 적어도 괜찮음!!
            case BUS :
                System.out.println("버스");
                break;
            //case SUBWAY :
                //System.out.println("지하철");
                // break;
            // case TAXI :
                // System.out.println("택시");
                // break;
        }
    }
}
