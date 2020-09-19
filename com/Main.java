package com;

import java.net.InetSocketAddress;

import com.server.socket.SocketServer;
import com.server.socket.SocketServerImp;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SocketServer server = new SocketServerImp(new InetSocketAddress("localhost", 32100));

        Thread serverThread = new Thread(server);
        serverThread.start();

    }
}