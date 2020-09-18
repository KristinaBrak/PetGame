package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser implements Parser {

    static File file;

    public JSONParser(String fileName) {
        file = new File(fileName);
    }

    @Override
    public String parse() {

        JSONObject obj = getFileContent();
        System.out.println(obj.toString());

        String playerName = obj.getString("Name");
        String petName = obj.getJSONObject("Pet").getString("PetName");
        
        System.out.println("Player name: " + playerName);
        System.out.println("Pet name: " + petName);
        
        Player petOwner = new PetOwner(playerName);
        petOwner.createPet(petName);

        JSONArray statuses = obj.getJSONArray("Statuses");
        for (int i = 0; i < statuses.length(); i++) {
            // System.out.println(statuses.get(i));
            petOwner.getPet().getStatuses();
            System.out.println(statuses.getJSONObject(i));

        }

        // System.out.println(petName);
        return null;
    }

    private JSONObject getFileContent() {
        JSONObject obj = null;
        try {
            String text = "";
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text += scanner.nextLine().trim();
            }
            scanner.close();
            obj = new JSONObject(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
