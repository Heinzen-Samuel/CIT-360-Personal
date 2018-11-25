package cit360acp;

import java.lang.String;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("CIT 360 ACP test (Using CIT 360 Java Collections Program Code)");

        ApplicationController appController = new ApplicationController();
        appController.mapCommand("Lists", new ListHandler());
        appController.mapCommand("Sets", new SetHandler());
        appController.mapCommand("Maps", new MapHandler());
        appController.mapCommand("Queues", new QueueHandler());
        appController.mapCommand("Trees", new SetHandler());

        boolean exit;
        exit = false;

        Scanner userInput = new Scanner(System.in);
        String choice;

        while (!exit) {

            System.out.println("Select option by entering the corresponding number");
            System.out.println("1 - Test Lists");
            System.out.println("2 - Test Sets");
            System.out.println("3 - Test Maps");
            System.out.println("4 - Test Queses");
            System.out.println("5 - Test Trees");
            System.out.println("6 - Exit program");

            choice = userInput.nextLine();

            switch (choice) {
                case "1":
                    appController.handleRequest("Lists");
                    break;
                case "2":
                    appController.handleRequest("Sets");
                    break;
                case "3":
                    appController.handleRequest("Maps");
                    break;
                case "4":
                    appController.handleRequest("Queues");
                    break;
                case "5":
                    appController.handleRequest("Trees");
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("Input did not match any options. Try again\n");
                    break;
            }
        }
    }
}
