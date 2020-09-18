package com.server.messenger;


import org.java_websocket.WebSocket;
import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

public class MessengerWSImp implements Messenger {
    private WebSocket connection;
    private Queue<String> queue;

    public MessengerWSImp(WebSocket connection) {
        this.connection = connection;
        queue = new LinkedList<String>();
    }

    @Override
    public boolean hasMessage() {
        return !queue.isEmpty();
    }

    @Override
    public String getMessage() {
        return queue.poll();
    }

    @Override
    public void append(String message) {
        queue.add(message);
        System.out.println("Appended to queue:" + message);
    }

    @Override
    public void send(String message) {
        connection.send(message);
    }

    @Override
    public void send(JSONObject object) {
        connection.send(object.toString());
    }

}
