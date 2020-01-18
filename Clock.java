import java.util.PriorityQueue;

public class Clock extends Thread {

    PriorityQueue<Action> set = new PriorityQueue<Action>();

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
            // System.out.println("tick");
            PriorityQueue<Action> temp = new PriorityQueue<Action>(set);
            for (int i = 0; i < set.size(); i++) {
                Action a = temp.poll();
                if (a != null)
                    a.act();
            }
            delay(delay);
        }
    }

    public void setSpeed(long delay){
        this.delay = delay;
    }

    public void pause() {
        running = false;
    }

}