package com.server;

public interface Server extends Runnable {

    void start();

    Messenger getMessenger();

}