package cit360acp;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class ListHandler implements Handler {
    @Override
    public void handleIt(){
        System.out.println("Running \"Lists\" test\n");

        System.out.println("In this test, the code will simulate creating a random anagram.\n" +
                "A recent & popular two word phrase has been hard coded and needs to be guessed after the phrase has " +
                "been randomized.\nThe use of lists via the vector class will allow for the phrase to be stored, shuffled, " +
                "and tracked.\nFor every incorrect attempt, a different version of the phrase will be shown (stored as the " +
                "previous object in the vector).\nIf the user is unable to guess correctly till the final phrase is revealed " +
                "- the user loses.\n");

        int score = 3;
        Vector wordOne = new Vector();
        Vector wordTwo = new Vector();
        Collections.addAll(wordOne, "W", "a", "k", "a", "n", "d", "a");
        Collections.addAll(wordTwo, "F", "o", "r", "e", "v", "e", "r");
        Vector randomPhrases = new Vector();

        for (int i = 0; i < 4; i++) {
            Collections.shuffle(wordOne);
            Collections.shuffle(wordTwo);

            Vector finalword = new Vector();
            Collections.addAll(finalword, wordOne, " ", wordTwo);

            String finalVersion = finalword.toString()
                    .replace(", ", "")  //remove the commas
                    .replace("[", "")  //remove the right bracket
                    .replace("]", "")  //remove the left bracket
                    .trim();           //remove trailing spaces from partially initialized arrays

            randomPhrases.add(finalVersion);
        }

        Scanner userGuess = new Scanner(System.in);
        String guess;

        while(score > 0) {

            System.out.println("the current version is: " + randomPhrases.get(score));

            guess = userGuess.nextLine();

            if (guess.equals("Wakanda Forever")) {
                System.out.println("CONGRADULATIONS! Wakanda Forever!\nYour Score: " + score + "\n");
                break;
            }
            else {
                System.out.println("Oops! Incorrect answer!");
                score--;
            }
        }

        if (score == 0) {
            System.out.println("Sadly, you lost! Try again if you want!\n");
        }
    }
}
