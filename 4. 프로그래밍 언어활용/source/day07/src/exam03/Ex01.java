package exam03;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        Resources res = new Resources();
        Resource2 res2 = new Resource2();
        try(res; res2) { // try ~ with ~ resources 구문
            // res 가 AutoCloseable 인터페이스 구현 객체인지 체크 -> 맞으면 close() 메서드 자동 호출 | Resources.java 의 close() 호출
            // AutoCloseable auto = res; | auto.close(); 이게 구현될 때만 자동으로 호출 O
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
