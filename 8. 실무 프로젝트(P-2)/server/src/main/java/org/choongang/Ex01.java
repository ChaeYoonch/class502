package org.choongang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ex01 { // 데이터 병렬적으로 전달할 수 있는지 테스트 용
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999); // 127.0.0.1 = localhost
        Scanner sc = new Scanner(System.in);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        while (true) {
            try(DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    System.out.print("메세지 : ");
                    String message = sc.nextLine();

                    SocketData data = new SocketData("user01", "all", message, LocalDateTime.now()); // all : 모든 사용자
                    String json = om.writeValueAsString(data);

                    dos.writeUTF(json);
                }
            } // try
        } // while
    }
}
