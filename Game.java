import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to Pet Game!");

        System.out.println("Enter your name");
        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();

        PetOwner player = new Player(playerName);

        System.out.println("How will you call your pet?");
        String petName = scan.nextLine();

        player.createPet(petName);

        System.out.printf("Your name is %s and \n your pet name is %s\n", playerName, petName);
    }
}