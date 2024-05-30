package org.choongang;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex02 { // 데이터 병렬적으로 전달할 수 있는지 테스트 용
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999); // 127.0.0.1 = localhost
        Scanner sc = new Scanner(System.in);

        while (true) {
            try(DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    System.out.print("메세지 : ");
                    String message = sc.nextLine();
                    dos.writeUTF(message);
                }
            } // try
        } // while
    }
}