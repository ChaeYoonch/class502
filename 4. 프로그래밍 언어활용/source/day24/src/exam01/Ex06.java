package exam01;

public class Ex06 {
    public static void main(String[] args) {
        Thread th = new Thread(() -> {
            Thread th2 = Thread.currentThread();
            int num = 0;
            while(!th2.isInterrupted()) {
                System.out.println(num++);

                for(long j = 0; j < 10000000L; j++);
            }
        });

        th.start();

        try {
            Thread.sleep(3000); // 3초 느리게
        } catch (InterruptedException e) {}

        th.interrupt(); // isInterrupted() -> true 로 바뀜 | interrupt = 동영상 stop 버튼과 동일한 역할
    }
}
