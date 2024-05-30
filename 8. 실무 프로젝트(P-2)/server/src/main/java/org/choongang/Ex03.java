package org.choongang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999); // 127.0.0.1 = localhost
        Scanner sc = new Scanner(System.in);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        Thread th = new Thread(() -> {
            try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                while (true) {
                    String json = dis.readUTF();
                    System.out.println(json);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try(DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                System.out.print("전송 : ");
                String to = sc.nextLine();

                System.out.print("메세지 : ");
                String message = sc.nextLine();

                SocketData data = new SocketData("user02", "all", message, LocalDateTime.now()); // all : 모든 사용자
                String json = om.writeValueAsString(data);

                dos.writeUTF(json);
            } // try
        } // while
    }
}
