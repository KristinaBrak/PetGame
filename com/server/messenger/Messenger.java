package com.server.messenger;

import org.json.JSONObject;

public interface Messenger {

    boolean hasMessage();

    String getMessage();

    void append(String message);

    void send(String message);

    void send(JSONObject object);

}