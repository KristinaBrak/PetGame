package com;

import com.game.Game;
import com.game.GameImp;
import com.game.GameLoop;
import com.game.GameLoopImp;
import com.persistance.Persistance;
import com.persistance.PersistanceImp;
import com.server.Server;
import com.server.ServerImp;

public class Main {
    public static void main(String[] args) {

        Persistance persistance = new PersistanceImp("test1.ser");
        Player player = (PetOwner) persistance.load();

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

        Server server = new ServerImp();
        Thread serverThread = new Thread(server);
        serverThread.start();

        while (server.getMessenger() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Game game = new GameImp(player, server.getMessenger());
        GameLoop gameLoop = new GameLoopImp(game);
        gameLoop.start();
    }
}