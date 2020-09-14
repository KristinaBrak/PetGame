package com.server.socket;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class SocketServerImp extends WebSocketServer implements SocketServer {

    public SocketServerImp(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println(
                "closed " + conn.getRemoteSocketAddress() + " with exit code " + code + " additional info: " + reason);

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("an error occurred on connection " + conn.getRemoteSocketAddress() + ":" + ex);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("received message from " + conn.getRemoteSocketAddress() + ": " + message);

    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!"); // This method sends a message to the new client
        System.out.println("new connection to " + conn.getRemoteSocketAddress());

    }

    @Override
    public void onStart() {
        System.out.println("server started successfully");
    }

}
