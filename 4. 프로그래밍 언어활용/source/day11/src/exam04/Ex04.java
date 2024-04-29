package exam04;

import java.util.LinkedList;
import java.util.Queue;

public class Ex04 {
    public static void main(String[] args) {
        Queue<Integer> items = new LinkedList<>();
        items.offer(1); // offer 가 Queue 의 시그니처 메서드
        items.offer(2);
        items.offer(3); // 추가 순서대로 = 1-2-3 순으로 들어가고 나옴

        System.out.println(items.poll()); // 1
        System.out.println(items.poll()); // 2
        System.out.println(items.poll()); // 3
    }
}
