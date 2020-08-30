package com.server;

public interface Messenger {

    boolean hasMessage();

    String getMessage();

    void receive(String message);

    void send(String message);

}