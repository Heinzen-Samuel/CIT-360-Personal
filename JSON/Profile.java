package cit360json;

import java.util.Vector;

public class Profile {

    private String name;
    private int level;
    private String char_race;
    private String char_class;

    public Profile(String new_name, int new_level, String new_character) {
        name = new_name;
        level = new_level;

        switch (new_character.charAt(0)) {
            case 'H':
                char_race = "Human";
                break;
            case 'E':
                char_race = "Elf";
                break;
            case 'O':
                char_race = "Orc";
                break;
        }

        switch (new_character.charAt(1)) {
            case 'W':
                char_class = "Warrior";
                break;
            case 'A':
                char_class = "Archer";
                break;
            case 'M':
                char_class = "Mage";
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getChar_race() {
        return char_race;
    }

    public String getChar_class() {
        return char_class;
    }

    public String toString() {
        String profileString;

        profileString = "Profile: " + name + " | Level: " + level +
                " | Character: " + char_race + " " + char_class;

        return profileString;
    }
}
