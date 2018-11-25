package cit360acp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueHandler implements Handler {
    @Override
    public void handleIt(){
        System.out.println("Running \"Queues\" test\n");

        System.out.println("In this test, a queue will be used to count the vowels of the\ninput and display them " +
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
}
