package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.game.GameConfig;
import com.server.input.InputHandler;
import com.server.input.InputHandlerImp;

public class ServerImp implements Server {
    private static final int LISTENING_PORT = GameConfig.LISTENING_PORT;
    private ServerSocket listener;
    private Socket connection;

    @Override
    public void start() {
        System.out.println("starting server...");
        try {
            listener = new ServerSocket(LISTENING_PORT);
            while (true) {
                connection = listener.accept();
                System.out.println("connection accomplished..");
                handleConnection();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleConnection() throws IOException {
        Scanner inputStreamScanner = new Scanner(connection.getInputStream());

        System.out.println("connection is open");
        while (!connection.isClosed()) { /* Connection is closed by client */
            if (inputStreamScanner.hasNext()) {
                String input = inputStreamScanner.next();
                System.out.println("Reading input from client: ");
                InputHandler inputHandler = new InputHandlerImp(input);
                System.out.println(inputHandler.getInput()); // TODO delete after testing
            } else {
                break;
            }

        }
        System.out.println("connection is closed");
        inputStreamScanner.close();
        System.out.println("scanner closed.");
    }

}