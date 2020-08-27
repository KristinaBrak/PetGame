package com.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
    private static final String serverMessage = "Server got: ";

    @Override
    public void start() {
        System.out.println("starting server...");
        try {
            listener = new ServerSocket(LISTENING_PORT);
            while (true) {
                connection = listener.accept();
                // System.out.println("connection accomplished..");
                handleConnection();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleConnection() throws IOException {
        Scanner inputStreamScanner = new Scanner(connection.getInputStream());
        OutputStream outputStream = connection.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream);

        // System.out.println("connection is open");
        while (!connection.isClosed() && inputStreamScanner.hasNext()) { /* Connection is closed by client */
            String input = inputStreamScanner.next();
            // System.out.print("Reading input from client: ");
            createEventHandler(input);
            sendResponseToClient(input, out);
            // System.out.println(inputHandler.getInput()); // TODO delete after testing

        }
        System.out.println("connection is closed");
        inputStreamScanner.close();
        outputStream.close();
        out.close();
    }

    @Override
    public void createEventHandler(String input) {
        InputHandler inputHandler = new InputHandlerImp(input);
    }

    private void sendResponseToClient(String message, PrintWriter out) {
        // System.out.println("sendResponseToClient entered");

        out.println(serverMessage + message);
        System.out.println("Sent " + serverMessage + message);
        out.flush();

    }

}