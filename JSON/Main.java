package cit360json;

import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class Main {

    private static ArrayList<Profile> profiles = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("CIT 360 JSON Example");
        boolean exit;
        exit = false;

        Scanner userInput = new Scanner(System.in);
        String choice;

        while (!exit) {
            System.out.println("Select option by entering the corresponding number");
            System.out.println("1 - Create&Add Java Object \"Profile\"");
            System.out.println("2 - Convert Java \"Profiles\" to JSON");
            System.out.println("3 - Convert JSON \"Profiles\" to Java Object");
            System.out.println("4 - Show all Java Object \"Profiles\"");
            System.out.println("5 - Exit program");

            choice = userInput.nextLine();

            switch (choice) {
                case "1":
                    createAddProfile();
                    break;
                case "2":
                    convertJavaJSON();
                    break;
                case "3":
                    convertJSONJava();
                    break;
                case "4":
                    showAllProfiles();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Input did not match any options. Try again\n");
                    break;
            }
        }
    }

    private static void createAddProfile() {
        System.out.println("Creating and adding a profile\n");

        // Profile name is entered
        System.out.print("Enter Profile Name:");
        Scanner userName = new Scanner(System.in);
        String name;
        name = userName.nextLine();

        // Profile level is random
        Random rand = new Random();
        int user_level = rand.nextInt(10);

        // Profile character is random
        String character = "";

        int user_race = rand.nextInt(3);
        switch (user_race) {
            case 0 :
                character += "H";
                break;
            case 1 :
                character += "E";
                break;
            case 2 :
                character += "O";
                break;
        }

        int user_class = rand.nextInt(3);
        switch (user_class) {
            case 0 :
                character += "W";
                break;
            case 1 :
                character += "A";
                break;
            case 2 :
                character += "M";
                break;
        }

        Profile new_profile = new Profile(name, user_level, character);
        profiles.add(new_profile);
        System.out.println("Profile created and added\n");
    }

    private static void convertJavaJSON() {
        System.out.println("Converting all Java objects to JSON");

        if(!profiles.isEmpty()) {
            JSONArray json_profiles = new JSONArray();

            for (int i = 0; i < profiles.size(); i++) {
                JSONObject object = new JSONObject();

                String json_character = "";
                String profile_race = profiles.get(i).getChar_race();
                switch(profile_race){
                    case "Human":
                        json_character += "H";
                        break;
                    case "Elf":
                        json_character += "E";
                        break;
                    case "Orc":
                        json_character += "O";
                        break;
                }

                String profile_class = profiles.get(i).getChar_class();
                switch (profile_class){
                    case "Warrior":
                        json_character += "W";
                        break;
                    case "Archer":
                        json_character += "A";
                        break;
                    case "Mage":
                        json_character += "M";
                        break;
                }

                object.put("Character", json_character);
                object.put("Level", profiles.get(i).getLevel());
                object.put("Name", profiles.get(i).getName());

                json_profiles.add(object);
            }

            try (FileWriter file = new FileWriter("profiles.json")) {
                file.write(json_profiles.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            profiles.clear();

            System.out.println("All profiles have been converted to JSON.\n" +
                    "They are stored locally as \"profiles.json\"\n");
        }
        else {
            System.out.println("Error: There are currently no profiles.\nCreate or load profiles to use this option\n");
        }
    }

    private static void convertJSONJava() {
        System.out.println("Converting JSON to Java objects");

        try {
            profiles.clear();
            JSONArray array = (JSONArray) new JSONParser().parse(new FileReader("profiles.json"));

            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                String name = (String) obj.get("Name");

                long temp_level = (long) obj.get("Level");
                int level = (int) temp_level;

                String character = (String) obj.get("Character");

                Profile new_profile = new Profile(name, level, character);
                profiles.add(new_profile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Profile loaded from JSON file\n");
    }

    private static void showAllProfiles() {
        System.out.println("Showing all Java objects\n");

        if(!profiles.isEmpty()) {

            for (int i = 0; i < profiles.size(); i++) {
                System.out.println(profiles.get(i).toString());
            }
            System.out.println();

        }
        else {
            System.out.println("Error: There are currently no profiles.\nCreate or load profiles to use this option\n");
        }
    }
}
