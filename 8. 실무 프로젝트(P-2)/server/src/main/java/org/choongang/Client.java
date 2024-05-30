package org.choongang;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999); // locahost == 127.0.0.1
    }
}
