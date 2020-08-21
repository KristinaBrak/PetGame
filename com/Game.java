package com;

import java.util.Scanner;

import com.food.Food;
import com.food.FoodImp;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to Pet Game!");

        System.out.println("Enter your name");
        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();

        Player player = new PetOwner(playerName);

        System.out.println("How will you call your pet?");
        String petName = scan.nextLine();
        scan.close();
        player.createPet(petName);

        Food apple = new FoodImp("Apple", 10);
        player.getPet().eat(apple);

        // System.out.printf("Your name is %s and \n your pet name is %s\n", playerName,
        // petName);
    }
}