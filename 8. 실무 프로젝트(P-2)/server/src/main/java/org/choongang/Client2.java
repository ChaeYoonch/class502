package org.choongang;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999); // locahost == 127.0.0.1
    }

    /* // 클라이언트 -> 서버 쪽으로 데이터 전송 (할당 받은 동적 포트를 통하여)
    OutputStream out = socket.getOutputStream;
    DataOutputStream dos = new DataOutputStream(out);

    dos.writeUTF("안녕하세요."); */
}
