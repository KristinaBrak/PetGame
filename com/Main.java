package com;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;

import com.game.Game;
import com.game.GameImp;
import com.game.GameLoop;
import com.game.GameLoopImp;
import com.persistance.Persistance;
import com.persistance.PersistanceImp;
import com.server.Server;
import com.server.ServerImp;
import com.server.messenger.*;

import com.server.socket.SocketServer;
import com.server.socket.SocketServerImp;

import org.java_websocket.server.WebSocketServer;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Persistance persistance = new PersistanceImp("test1.ser");
        Player player = (PetOwner) persistance.load();
        // System.out.println(player.getPet().getStatuses());

        // Scanner scanner = new Scanner(System.in);
        // Thread thread = new Thread() {
        // @Override
        // public void run() {
        // String input = "";
        // while (!input.equals("x")) {
        // System.out.println("Please enter stuff");
        // input = scanner.nextLine();
        // }
        // gameLoop.stop();
        // }
        // };
        // thread.start();
        // gameLoop.execute();
        // scanner.close();

        // gameLoop.stop();
        // ----------

        SocketServer server = new SocketServerImp(new InetSocketAddress("localhost", 32100));

        Thread serverThread = new Thread(server);
        serverThread.start();
        
        while (server.getMessenger() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Game game = new GameImp(player, server.getMessenger());
        GameLoop gameLoop = new GameLoopImp(game);
        gameLoop.start();
        // -----------------

        // Parser parser = new JSONParser("data.json");

        // String parseResult = parser.parse();
        // System.out.println(parseResult);
    }
}