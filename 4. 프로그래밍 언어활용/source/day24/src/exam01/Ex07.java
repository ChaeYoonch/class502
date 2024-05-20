package exam01;

public class Ex07 {
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(() -> {
            Thread th2 = Thread.currentThread();
            while(true) {
                try {
                    System.out.println("isInterrupted : " + th2.isInterrupted());
                    // for (int j = 0; j < 1000000000L; j++);
                   Thread.sleep(10000); // WAITING 일시 정지
                    // interrupted() -> InterruptedException 발생, isInterrupted 가 다시 false 로 변경됨
                    // 결과 = dhksisInterrupted : false -> InterruptedException 발생! -> isInterrupted : false

                } catch (InterruptedException e) { // RUNNABLE 실행 대기
                    System.out.println("InterruptedException 발생!"); // 요기로 유입되어 실행됨
                    th2.interrupt(); // InterruptedException 발생 -> isInterrupted 를 true 로 또다시 변경
                }
            }
        });

        th.start(); // 실행하면, 3초 뒤에
        Thread.sleep(3000); // 위에서 10초 대기라고 했어도 여기서 3초 대기 후
        th.interrupt(); // InterruptedException 발생 , isInterrupted -> true 로 변경
    }
}
