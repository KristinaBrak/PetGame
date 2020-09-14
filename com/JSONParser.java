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

        try {
            String text = "";
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text += scanner.nextLine().trim();
            }
            // System.out.println(text);
            JSONObject obj = new JSONObject(text);

            String petName = obj.getJSONObject("Pet").getString("PetName");
            JSONArray statuses = obj.getJSONArray("Statuses");
            for (int i = 0; i < statuses.length(); i++) {
                System.out.println(statuses.get(i));
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        }

        // System.out.println(petName);
        return null;
    }

}
