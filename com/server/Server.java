package com.server;

import com.server.messenger.Messenger;


public interface Server extends Runnable {

    void start();

    Messenger getMessenger();

}