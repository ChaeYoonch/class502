package 연습문제;

public class Q02 { // 학생 40명이 리조트로 수학여행, 방이 10개 있고 방번호 0~9번, 한 방에 4명씩 배정(예 : 학생1, 방번호 1번)
    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            int roomNo = i % 10; // 0~9 나머지
            System.out.printf("학생%d, 방번호 %d번%n", i, roomNo);
        }
    }
}
