package com.server;

import org.json.JSONObject;

public interface Messenger {

    boolean hasMessage();

    String getMessage();

    void receive(String message);

    void send(String message);

    void send(JSONObject object);

}