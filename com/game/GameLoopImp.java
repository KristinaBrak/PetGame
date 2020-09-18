package com.game;

import java.lang.Thread;

public class GameLoopImp implements GameLoop {
    private Game game;
    private boolean isGameRunning;

    public GameLoopImp(Game game) {
        this.game = game;
        isGameRunning = true;
    }

    private void start() {
        printExecuteMessage(); // TODO delete after testing

        while (isGameRunning) {
            game.update();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        game.close();

    }

    @Override
    public void stop() {
        isGameRunning = false;
        printStopMessage(); // TODO delete after testing
    }

    private void printStopMessage() {
        System.out.println("gameloop has stopped");
    }

    private void printExecuteMessage() {
        System.out.println("Executing...");
    }

    @Override
    public void run() {
        start();
    }

}