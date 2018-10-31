package cit360junit;

import java.util.Arrays;
import java.util.Random;

public class Hero {

    private String hero_class;
    private int health;
    private int strength;
    private boolean disease;
    private String items[];

    public Hero(String chosen_class, int class_health, int class_strength){
        hero_class = chosen_class;
        health = class_health;
        strength = class_strength;
        disease = false;
        items = new String[]{"Potion", "Potion", "Bread"};
    }

    public String getHeroClass() {
        return hero_class;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isDisease() {
        return disease;
    }

    public String[] getItems() {
        return items;
    }

    public void takeDamage(int hitAmount) {
        health = health - hitAmount;
    }

    public void useItem(String item) {

        for (int i = 0; i < items.length; i++) {

            // If Item is found
            if(items[i].equals(item)){

                // Item is removed from array
                for (int j = i; j < items.length - 1; j++) {
                    items[j] = items[j+1];
                    items[j+1] = null;
                }

                // if item was a potion then disease is healed and strength
                // returns to normal
                if (item.equals("Potion")) {
                    disease = false;
                    strength = 10;
                }

                // if item was bread then health is raised
                if (item.equals("Bread")) {

                    //Prevents health of exceeding 100
                    if (health > 80) {
                        health = 100;
                    }
                    else {
                        health = health + 20;
                    }
                }

                break;
            }
        }
    }

    public boolean addItem(String item) {

        // finds the first null spot to add item
        for (int i = 0; i < items.length; i++) {
            if(items[i] == null) {
                items[i] = item;
                return true;
            }
        }

        return false;
    }

    public void getDisease() {
        if (health < 20) {
            disease = true;

            Random newStrength = new Random();

            // While loop ensures that strength can never be the standard 10
            // after contracting a disease
            while (strength == 10) {
                strength = 0 + newStrength.nextInt(15);
            }
        }
    }
}
