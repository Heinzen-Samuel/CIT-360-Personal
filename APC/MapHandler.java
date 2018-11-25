package cit360acp;

import java.util.*;

public class MapHandler implements Handler {
    @Override
    public void handleIt(){
        System.out.println("Running \"Maps\" test\n");

        System.out.println("This test uses a Map to score any phrase the user types. The key is the\n\"Char\"" +
                " for each letter and the value is the associated \"Int\".\nValues were determined by the most commonly" +
                " used letters in the\nEnglish language. The rarer the letter, the higher the score. Capital letters\n" +
                "are counted as zero.\nEnter a phrase when you are ready:\n");

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

        System.out.println("Your word score is: " + score + ". Well done!\n");}
}
