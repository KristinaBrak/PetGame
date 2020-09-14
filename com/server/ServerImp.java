package com.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.game.GameConfig;

public class ServerImp implements Server {
    private static final int LISTENING_PORT = GameConfig.LISTENING_PORT;
    private ServerSocket listener;
    private Socket connection;
    private static final String serverMessage = "Server got: ";
    private Messenger messenger;

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
        } catch (NoSuchAlgorithmException e) {
        }
    }

    private void handleConnection() throws IOException, NoSuchAlgorithmException {
        var is = connection.getInputStream();
        Scanner inputStreamScanner = new Scanner(is, "UTF-8");
        OutputStream outputStream = connection.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream);
        messenger = new MessengerImp(out);

       
        System.out.println("connection is open");

        while (!connection.isClosed() && inputStreamScanner.hasNext())

        { /* Connection is closed by client */
            String input = inputStreamScanner.next();
            System.out.print("Reading input from client: ");
            messenger.receive(input);
            // System.out.println(inputHandler.getInput()); // TODO delete after testing

        }
        System.out.println("connection is closed");
        inputStreamScanner.close();
        outputStream.close();
        out.close();
    }

    @Override
    public Messenger getMessenger() {
        return this.messenger;
    }

    @Override
    public void run() {
        start();
    }

}