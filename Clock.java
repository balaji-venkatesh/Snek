import java.util.HashSet;

public class Clock extends Thread{

    HashSet<Clockable> set = new HashSet<Clockable>();

    long delay;
    boolean running;
    
    public Clock(long delay){
        this.delay = delay;
    }

    public boolean schedule(Clockable c){
        return set.add(c);
    }

    public boolean deSchedule(Clockable c){
        return set.remove(c);
    }

    public void run(){
        running = true;
        while(running){
            try{
                Thread.sleep(delay);
            }
            catch(InterruptedException e){

            }
            for(Clockable c : set) c.act();
        }
    }

    public void pause(){
        running = false;
    }

}