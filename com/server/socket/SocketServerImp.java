package com.server.socket;

import java.net.InetSocketAddress;

import com.Player;
import com.PetOwner;
import com.game.Game;
import com.game.GameImp;
import com.game.GameLoop;
import com.game.GameLoopCreator;
import com.game.GameLoopImp;
import com.persistance.Persistance;
import com.server.messenger.*;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class SocketServerImp extends WebSocketServer implements SocketServer {

    Messenger messenger;
    GameLoop gameLoop;

    public SocketServerImp(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println(
                "closed " + conn.getRemoteSocketAddress() + " with exit code " + code + " additional info: " + reason);
        gameLoop.stop();
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("an error occurred on connection " + ":" + ex);
        gameLoop.stop();
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("received message from client " + conn.getRemoteSocketAddress() + ": " + message);
        messenger.append(message);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        // conn.send("Welcome to the server!"); // This method sends a message to the
        // new client
        System.out.println("new connection to " + conn.getRemoteSocketAddress());

        this.messenger = new MessengerWSImp(conn);
        messenger.send("welcome");

        this.gameLoop = GameLoopCreator.create(this.messenger);
        // this.gameLoop.run();
        Thread thread = new Thread(this.gameLoop);
        thread.start();
    }

    @Override
    public void onStart() {
        System.out.println("server started successfully");
    }

    @Override
    public Messenger getMessenger() {
        return this.messenger;
    }

}
