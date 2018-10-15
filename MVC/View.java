package cit360mvcSimple;

import java.util.Scanner;

public class View {

    public String newView(String runway, int moves) {
        clearScreen();
        System.out.println(runway + "\n" + moves + " moves left. Type \"left\" or \"right\"");

        Scanner userInput = new Scanner(System.in);
        String choice;
        choice = userInput.nextLine();

        if (choice.equals("left") || choice.equals("right")){
            return choice;
        }
        else {
            System.out.println(choice + " is not an available option\n");
            return "none";
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
