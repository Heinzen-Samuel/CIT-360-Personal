package cit360concurrencySimple;

import java.util.Random;

public class PlayerThread implements Runnable {

    private String name;
    private String teamName;
    private int speed;

    public PlayerThread(int number, String team) {
        name = "Player#" + number;
        teamName = team;

        Random newSpeed = new Random();
        speed = 1 + newSpeed.nextInt(10);
    }

    @Override
    public void run() {
        buildTower();
    }

    private void buildTower() {
        try {
            int run_time = (11 - speed)*1000;
            Thread.sleep(run_time);
            System.out.println(teamName + ": " + name + " passed the baton!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
