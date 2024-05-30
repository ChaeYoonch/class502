package org.choongang;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    private ServerSocket serverSocket;
    private ExecutorService threadPool;

    public Server() {
        try {
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadPool = new ThreadPoolExecutor(2, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<>(){});
    }

    public void start() {

        while (true) {
            try {
                Socket socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class SocketHandler { // 코드만 작성시 순서대로 안 나옴 -> 소켓으로 수신 & 전송 동시다발적으로 처리 O
        private Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        public void input() { // 수신 처리
            threadPool.execute(() -> { // ( 안에 실행할 작업 내용 작성 ) | 내용 : () -> {} | 데이터 = json 문자열 형태
                try(DataInputStream dis = new DataInputStream(socket.getInputStream())) {

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        public void output() { // 전송 처리
            threadPool.execute(() -> { // ( 안에 실행할 작업 내용 작성 ) | 내용 : () -> {}

            });
        }
    }
}
    /* public static void main(String[] args) { // throws Exception 으로 예외 전가로 정보 확인
         ServerSocket serverSocket = new ServerSocket(9999); // 9999 임의로 넣은 포트
        while (true) {
            System.out.println("서버 대기중");
            Socket socket = serverSocket.accept(); // 대기 상태 -> 상대가 접속해야 9999 포트로 연결됨 -> 연결된 소켓 반환

            System.out.println("클라이언트 서버 접속 : " + socket); // 접속하기 전까지 블락되어 있음
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String str = dis.readUTF();
            System.out.println("클라이언트가 보낸 메세지 : " + str);
        } */