package com;

import com.persistance.Persistance;
import com.persistance.PersistanceImp;

public class Main {
    public static void main(String[] args) {

        Persistance persistance = new PersistanceImp("test1.ser");

        String playerName = "Player1";
        Player player = new PetOwner(playerName);

        String petName = "Catherine";
        player.createPet(petName);
        persistance.save(player);
        // System.out.println("saved__________________________");
        PetOwner player1 = (PetOwner) persistance.load();
        // System.out.println("Player: " + player1.getName() +
        // player1.getPet().getName());

        // Pet pet = new PetImp("name");
        // persistance.save(pet);
        // System.out.println(pet.getStatuses());
        // pet.starve();
        // persistance.save(pet);
        // Pet pet1 = (PetImp) persistance.load();

        // for (Status status : pet1.getStatuses().values()) {
        // System.out.printf("StatusName: %s, value: %d \n", status.getName().name(),
        // status.getValue());
        // }
        // player.getPet().starve();
        // player.getPet().eat(apple);
        // player.getPet().eat(apple);

        // Scanner scanner = new Scanner(System.in);
        // GameLoop gameLoop = new GameLoopImp(new GameImp(player));
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

        // Server server = new ServerImp();
        // server.start();

    }
}