package exam03;

public class Ex01 {
    public static void main(String[] args) {
        try(Resources res = new Resources()) {
            // res 가 AutoClosable 인터페이스 구현 객체인지 체크 -> 맞으면 close() 메서드 자동 호출 | Resources.java 의 close() 호출
            // AutoClosable auto = res; | auto.close(); 이게 구현될 때만 자동으로 호출 O
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
