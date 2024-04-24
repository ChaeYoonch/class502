package exam04;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        // 로또 번호 : 1 ~ 43, 6개의 숫자 - 중복 X
        int cnt = 0;
        int[] lotto = new int[6];

        while(cnt < 6) {
            int num = getNumber();
            if (chkDuplicate(lotto, num)) {
                continue;
            }

            lotto[cnt] = num;
            cnt++;
        }

        System.out.println(Arrays.toString(lotto));
    }

    public static int getNumber() {
        return (int)(Math.random() * 43) + 1;
    }

    public static boolean chkDuplicate(int[] lotto, int num) {

        for (int n : lotto) {

            if (n == num) return true;
        }

        return false;
    }
}

/* public static void main(String[] args) {
    // int num = (int)(Math.random() * 43) + 1; // 1 ~ 43 | System.out.println(num);
     //System.out.println(Math.random() * 10);
        // 0 ~ 1 미만의 난수 실행 | 뒤에 곱하는 수보다 낮은 수가 1의 자리에 반복 | 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
} */