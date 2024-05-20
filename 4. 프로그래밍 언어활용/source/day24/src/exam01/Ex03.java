package exam01;

public class Ex03 {
    public static void main(String[] args) {
        /* Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread th = new Thread(runnable); // run() 은 new Thread 에서만 사용할 예정 */

        Thread th = new Thread(() -> System.out.println("실행 부분...")); // 람다식 으로 사용 가능 (함수형 인터페이스)
    }
}
