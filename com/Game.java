package com;

import com.food.Food;
import com.food.FoodImp;

public class Game {
    public static void main(String[] args) {

        String playerName = "Player1";

        Player player = new PetOwner(playerName);

        String petName = "Catherine";

        player.createPet(petName);

        Food apple = new FoodImp("Apple", 10);

        player.getPet().starve();
        player.getPet().eat(apple);
        player.getPet().eat(apple);

        EventCreator eventCreator = new EventCreatorImp(player.getPet());
        // System.out.printf("Your name is %s and \n your pet name is %s\n", playerName,
        // petName);
    }
}