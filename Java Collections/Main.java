package cit360JavaCollections;

import java.lang.String;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("CIT 360 Java Collections Test");
        boolean exit;
        exit = false;

        Scanner userInput = new Scanner(System.in);
        String choice;

        while (!exit) {
            System.out.println("Select option by typing the quoted word:");
            System.out.println("1 - Test \"lists\"");
            System.out.println("2 - Test \"sets\"");
            System.out.println("3 - Test \"maps\"");
            System.out.println("4 - Test \"queues\"");
            System.out.println("5 - Test \"trees\"");
            System.out.println("6 - \"exit\" program");

            choice = userInput.nextLine();

            switch (choice) {
                case "lists":
                    testLists();
                    break;
                case "sets":
                    testSets();
                    break;
                case "maps":
                    testMaps();
                    break;
                case "queues":
                    testQueues();
                    break;
                case "trees":
                    testTrees();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Input did not match any options. Try again\n");
                    break;
            }
        }
    }

    private static void testLists() {
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
                System.out.println("CONGRADULATIONS! Wakanda Forever!\nYour Score: " + score + "\n\n");
                break;
            }
            else {
                System.out.println("Oops! Incorrect answer!");
                score--;
            }
        }

        if (score == 0) {
            System.out.println("Sadly, you lost! Try again if you want!\n\n");
        }
    }

    private static void testSets() {
        System.out.println("Running \"Sets\" test\n");

        System.out.println("In this test, we will simulate a loot box system where the goal is to\ngain all possible" +
                " items within 10 tries. The set will be implemented\nusing a treeSet to maintain the order of" +
                " the final results.\nFor each turn, 3 random numbers will be selected and added to the result. If, after\n" +
                "10 tries, not all 10 numbers have been added, the user loses.\n");

        TreeSet userset = new TreeSet();
        TreeSet notfound = new TreeSet();
        Collections.addAll(notfound, 1,2,3,4,5,6,7,8,9,10);
        int tries = 1;

        pressAnyKeyToContinue();

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
            System.out.println("\nCongratulations! You got all 10 digits!\n\n");
        } else {
            System.out.println("\nLooks like you didn't get all 10 digits :(\n\n");
        }
    }

    private static void testMaps() {
        System.out.println("Running \"Maps\" test\n");

        System.out.println("This test uses a Map to score any phrase the user types. The key is the\n\"Char\"" +
                " for each letter and the value is the associated \"Int\".\nValues were determined by the most commonly" +
                " used letters in the\nEnglish language. The rarer the letter, the higher the score. Capital letters\n" +
                "are counted as zero.\nEnter a phrase when you are ready:\n\n");

        Map<Character,Integer> scoreboard = new HashMap<>();

        scoreboard.put('a', new Integer(40));
        scoreboard.put('b', new Integer(500));
        scoreboard.put('c', new Integer(100));
        scoreboard.put('d', new Integer(70));
        scoreboard.put('e', new Integer(20));
        scoreboard.put('f', new Integer(200));
        scoreboard.put('g', new Integer(400));
        scoreboard.put('h', new Integer(50));
        scoreboard.put('i', new Integer(40));
        scoreboard.put('j', new Integer(900));
        scoreboard.put('k', new Integer(700));
        scoreboard.put('l', new Integer(80));
        scoreboard.put('m', new Integer(100));
        scoreboard.put('n', new Integer(40));
        scoreboard.put('o', new Integer(40));
        scoreboard.put('p', new Integer(400));
        scoreboard.put('q', new Integer(800));
        scoreboard.put('r', new Integer(60));
        scoreboard.put('s', new Integer(40));
        scoreboard.put('t', new Integer(30));
        scoreboard.put('u', new Integer(90));
        scoreboard.put('v', new Integer(600));
        scoreboard.put('w', new Integer(300));
        scoreboard.put('x', new Integer(900));
        scoreboard.put('y', new Integer(300));
        scoreboard.put('z', new Integer(1000));

        Scanner userInput = new Scanner(System.in);
        String scoreword;
        scoreword = userInput.nextLine();

        Queue<Character> wordchar = new LinkedList<>();
        for (char c : scoreword.toCharArray()) {
            wordchar.offer(c);
        }

        int score = 0;

        while (wordchar.size() != 0) {
            char front = wordchar.remove();

            if (scoreboard.containsKey(front)) {
                score = score + scoreboard.get(front);
            }
        }

        System.out.println("Your word score is: " + score + ". Well done!\n\n");
    }

    private static void testQueues() {
        System.out.println("Running \"Queues\" test\n");

        System.out.println("In this test, a queue will be used to count the the vowels of the\ninput and display them " +
                "in the order they were found. There is no\nwinner or loser. This is just for science.\nEnter a word or " +
                "phrase:\n");

        Scanner userInput = new Scanner(System.in);
        String userword;
        userword = userInput.nextLine();

        Queue<Character> wordchar = new LinkedList<>();
        for (char c : userword.toCharArray()) {
            wordchar.offer(c);
        }

        int vowelcount = 0;
        Queue<Character> vowelsfound = new LinkedList<>();

        while (wordchar.size() != 0) {
            char front = wordchar.remove();

            if (front == 'A' ||
                front == 'a' ||
                front == 'E' ||
                front == 'e' ||
                front == 'I' ||
                front == 'i' ||
                front == 'O' ||
                front == 'o' ||
                front == 'U' ||
                front == 'u') {
                    vowelsfound.offer(front);
                    vowelcount++;
            }
        }

        System.out.println("Vowel count for input: " + vowelcount + "\nVowels Used: " + vowelsfound + "\n");
    }

    private static void testTrees() {
        System.out.println("Running \"Sets\" test due to a TreeSet being used.\n");
        testSets();
    }

    private static void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
