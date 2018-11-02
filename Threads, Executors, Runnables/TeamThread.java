package cit360concurrencySimple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TeamThread implements Runnable {

    private final static AtomicInteger mvp = new AtomicInteger(0);
    private final static AtomicBoolean win = new AtomicBoolean(false);
    private static String mvpName;
    private String teamName;
    private int teamSize;
    private int poolSize;

    public TeamThread(int size, int pool, String name) {
        teamName = name;
        teamSize = size;
        poolSize = pool;
    }

    @Override
    public void run() {
        List<Future<?>> Futures = new ArrayList<Future<?>>();
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < teamSize; i++) {
            PlayerThread player = new PlayerThread(i+1, teamName);
            Future<?> f = executor.submit(player);
            Futures.add(f);

            if (player.getSpeed() > mvp.get()) {
                mvp.getAndSet(player.getSpeed());
                mvpName = player.getName();
            }
        }

        executor.shutdown();

        boolean allDone = false;
        while(!allDone) {
            allDone = true;
            for(Future<?> future : Futures) {
                allDone &= future.isDone();
            }
        }

        System.out.println("\n" + teamName + " has finished the race!");
        if (!win.get()) {
            win.set(true);
            System.out.println("Their MVP was " + mvpName + " with a speed of " + mvp + "\n");
        }
        else {
            System.out.println("Sadly they lost - therefore their MVP was just not up to snuff");
        }
    }
}
