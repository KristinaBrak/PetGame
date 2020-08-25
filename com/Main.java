package com;

import java.util.Scanner;

// import com.food.Food;
// import com.food.FoodImp;
import com.game.GameImp;
import com.game.GameLoop;
import com.game.GameLoopImp;

public class Main {
    public static void main(String[] args) {

        String playerName = "Player1";
        Player player = new PetOwner(playerName);

        String petName = "Catherine";
        player.createPet(petName);

        // Food apple = new FoodImp("Apple", 10);
        // player.getPet().starve();
        // player.getPet().eat(apple);
        // player.getPet().eat(apple);

        Scanner scanner = new Scanner(System.in);
        GameLoop gameLoop = new GameLoopImp(new GameImp(player));
        Thread thread = new Thread() {
            @Override
            public void run() {
                String input = "";
                while (!input.equals("x")) {
                    System.out.println("Please enter stuff");
                    input = scanner.nextLine();
                }
                gameLoop.stop();
            }
        };
        thread.start();
        gameLoop.execute();
        scanner.close();
        // gameLoop.stop();
    }
}