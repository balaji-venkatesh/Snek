import java.util.HashSet;

public class Clock extends Thread {

    HashSet<Action> set = new HashSet<Action>();

    private long delay;
    private boolean running;

    public static void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public Clock(long delay) {
        this.delay = delay;
    }

    public boolean schedule(Action c) {
        return set.add(c);
    }

    public boolean deSchedule(Action c) {
        return set.remove(c);
    }

    public void run() {
        running = true;
        while (running) {
            for (Action c : set)
                c.act();
            delay(delay);
        }
    }

    public void pause() {
        running = false;
    }

}