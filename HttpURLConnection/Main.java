package cit360httpurl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("CIT 360 Http/URL Example");
        boolean exit;
        exit = false;

        Scanner userInput = new Scanner(System.in);
        String choice;

        while (!exit) {
            HttpURLExample jokeOfDay = new HttpURLExample();

            System.out.println("Select option by entering the corresponding number");
            System.out.println("1 - Get Dad joke");
            System.out.println("2 - Exit program");

            choice = userInput.nextLine();

            switch (choice) {
                case "1":
                    jokeOfDay.sendGet();
                    break;
                case "2":
                    exit = true;
                    break;
                default:
                    System.out.println("Input did not match any options. Try again\n");
                    break;
            }
        }
    }
}
