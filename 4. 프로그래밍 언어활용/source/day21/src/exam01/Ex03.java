package exam01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) {
        int[] scores = { 90, 88, 65, 10, 78, 98};

        try (FileOutputStream fos = new FileOutputStream("score.txt");
             DataOutputStream dos = new DataOutputStream(fos)) {

            for (int score : scores) {
                dos.writeInt(score);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
