package cit360concurrencySimple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        System.out.print("This program simulates a relay race between two teams. This is done by nesting two " +
                "runnable classes: TeamThread and PlayerThread. \nThe main function creates two team threads " +
                "that are executed besides each other. Within each of these threads are 4 threads representing " +
                "players \nwho are given random speed stats that affect the \"thread.sleep()\" method. Once all " +
                "the players have passed the baton, the team thread ends, \nexclaiming that they have finished" +
                "the race. To demonstrate an atomic variable, each team displays their MVP by updating an " +
                "AtomicInteger \nas each player is created. The player with the highest speed remains.\n\n");

        pressAnyKeyToRun();
        beginRace();

        System.out.println("\nThe race has finished!\n");
    }

    private static void beginRace() {
        System.out.println("The race has begun!\n");

        List<Future<?>> gameFutures = new ArrayList<Future<?>>();
        ExecutorService executorGame = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            TeamThread team = new TeamThread(4,2,"team " + (i + 1));
            Future<?> f = executorGame.submit(team);
            gameFutures.add(f);
        }

        executorGame.shutdown();

        boolean allDone = false;
        while(!allDone) {
            allDone = true;
            for(Future<?> future : gameFutures) {
                allDone &= future.isDone();
            }
        }
    }

    private static void pressAnyKeyToRun()
    {
        System.out.println("Press Enter key to run (*punny) the simulation....");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
