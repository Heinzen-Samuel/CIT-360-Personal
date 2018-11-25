package cit360acp;

import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class SetHandler implements Handler {
    @Override
    public void handleIt(){
        System.out.println("Running \"Sets\" or \"Trees\" test\n");

        System.out.println("In this test, we will simulate a loot box system where the goal is to\ngain all possible" +
                " items within 10 tries. The set will be implemented\nusing a treeSet to maintain the order of" +
                " the final results.\nFor each turn, 3 random numbers will be selected and added to the result. If, after\n" +
                "10 tries, not all 10 numbers have been added, the user loses.\n");

        TreeSet userset = new TreeSet();
        TreeSet notfound = new TreeSet();
        Collections.addAll(notfound, 1,2,3,4,5,6,7,8,9,10);
        int tries = 1;

        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }
        catch(Exception e) {}

        while (userset.size() < 10 && tries < 11) {

            for (int i = 0; i < 3; i++) {
                Random random = new Random();
                int max = 10;
                int min = 1;
                int randomInteger = random.nextInt(max - min + 1) + min;
                userset.add(randomInteger);
                notfound.remove(randomInteger);
            }

            System.out.println("Try " + tries + ". Current set: " + userset + "\n       Missing: " + notfound);

            try { Thread.sleep(2000); }
            catch (Exception e) { System.out.println(e); }

            tries++;
        }

        if (userset.size() == 10) {
            System.out.println("\nCongratulations! You got all 10 digits!\n");
        } else {
            System.out.println("\nLooks like you didn't get all 10 digits :(\n");
        }
    }
}
