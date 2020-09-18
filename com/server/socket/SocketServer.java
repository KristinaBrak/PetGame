package com.server.socket;

import com.server.messenger.Messenger;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public interface SocketServer extends Runnable {
    public void onClose(WebSocket conn, int code, String reason, boolean remote);

    public void onError(WebSocket conn, Exception ex);

    public void onMessage(WebSocket conn, String message);

    public void onOpen(WebSocket conn, ClientHandshake handshake);

    public void onStart();

    public Messenger getMessenger();
}