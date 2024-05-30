package org.choongang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Server {
    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private ObjectMapper om;
    private Map<String, Socket> clients; // 접속한 사용자 (소켓)

    public Server() {
        try {
            // 환경변수 -> port : port 등장시 포트 변경
            String  _port = System.getenv("port");
            int port = _port == null || _port.isBlank() ? 9999 : Integer.parseInt(_port);

            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadPool = new ThreadPoolExecutor(2, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<>(){});

        om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        clients = new HashMap<>();
    }

    public void start() {

        // 소켓 연결 상태 모니터링(= 체크)
        monitoring();

        while (true) {
            try {
                Socket socket = serverSocket.accept();

                SocketHandler handler = new SocketHandler(socket);

                // 수신 처리
                handler.input(data -> {
                    SocketData sData = toObject(data);
                    String from = sData.getFrom(); // 보낸 사람
                    // 최초 접속인 경우 -> 사용자(소켓) 등록
                    if (!clients.containsKey(from)) {
                        clients.put(from, socket);
                    }

                    // 전송
                    String to = sData.getTo();
                    handler.send(to, sData);
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private SocketData toObject(String json) { // json -> 자바 객체로 변환
        SocketData data = null;
        try {
            data = om.readValue(json, SocketData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return data;
    }

    private String toJSON(SocketData sData) { // 자바 객체 -> json 으로 변환
        String data = null;
        try {
            data = om.writeValueAsString(sData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * 소켓 연결이 종료된 경우 -> clients 에서 제거
     * 5초마다 소켓 연결 상태 체크
     */
    public void monitoring() {
        Thread th = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}

                for (Map.Entry<String, Socket> client : clients.entrySet()) {
                    if (client.getValue().isClosed()) {
                        clients.remove(client.getKey());
                    }
                }
            }
        });

        th.setDaemon(true);

        th.start();
    }

    class SocketHandler { // 코드만 작성시 순서대로 안 나옴 -> 소켓으로 수신 & 전송 동시다발적으로 처리 O
        private Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }
        // 수신 처리
        public void input(Consumer<String> handler) {
            threadPool.execute(() -> { // ( 안에 실행할 작업 내용 작성 ) | 내용 : () -> {} | 데이터 = json 문자열 형태
                try {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());

                    while (true) {

                        if (socket == null || socket.isClosed() || handler == null) { // is.Closed : 닫힌 경우
                            Thread.currentThread().yield(); // 멈추고 다음 작업 쓰레드 순서로 넘김
                            break; // 오류 때문에 socket 이 해제되는 경우
                        }

                        String data = dis.readUTF();
                        handler.accept(data);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } // 데이터가 들어오면 데이터만 나가도록 함수형 인터페이스로 데이터 연결함
            });
        }

        // 전송 처리
        public void output(Socket toSocket, SocketData data) { // 보내는 쪽
            if (toSocket == null || toSocket.isClosed() || data == null) {
                return;
            }

            threadPool.execute(() -> { // ( 안에 실행할 작업 내용 작성 ) | 내용 : () -> {}
                try {
                    DataOutputStream dos = new DataOutputStream(toSocket.getOutputStream());
                    String json = toJSON(data);
                    dos.writeUTF(json);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        /**
         * 메세지 전송
         *
         * @param to
         *           all : 모든 접속자
         *           request_users : 모든 접속자 목록 반환
         *           request_exit : 연결 종료 -> 본인 소켓 close -> 소켓 제거
         * @param data
         */
        public void send(String to, SocketData data) {

            data.setRegDt(LocalDateTime.now());

            if (to.equals("all")) { // 전체 전송
                clients.values().forEach(s -> output(s, data));

            } else if (to.equals("request_users")) { // 모든 접속자 목록
                to = data.getFrom(); // 요청 정보는 요청한 사용자에게 반송

                String message = clients.keySet().stream().collect(Collectors.joining("||")); // 사용자 목록 가져와서 보냄
                data.setMessage(message);

                Socket s = clients.get(to);
                output(s, data);

            } else if (to.equals("request_exit")) { // 접속 종료
                String from = data.getFrom();
                Socket s = clients.get(from);
                if (s != null) {
                    if (!s.isClosed()) {
                        try {
                            s.close();
                        } catch (IOException e) {}
                    }

                    clients.remove(from); // 바로 제거
                }
            } else { // 특정 사용자 전송
                Socket s = clients.get(to);
                if (s != null) {
                    output(s, data);
                }
            }
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