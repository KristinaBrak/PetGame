package com.server.messenger;


import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

public class MessengerImp implements Messenger {
    PrintWriter out;
    Queue<String> queue;

    public MessengerImp(PrintWriter out) {
        this.out = out;
        queue = new LinkedList<String>();
    }

    // send to client
    @Override
    public void send(String message) {
        out.println(message);
        out.flush();
    }

    @Override
    public void send(JSONObject object) {

    }

    @Override
    public boolean hasMessage() {
        return !queue.isEmpty();
    }

    @Override
    public String getMessage() {
        return queue.poll();
    }

    // adds to queue
    @Override
    public void append(String message) {
        queue.add(message);
        System.out.println("Received:" + message);
    }

}