public abstract class Action implements Comparable<Action>{

    public int priority = 0;

    public Action(int priority){
        this.priority = priority;
    }

    abstract void act();

    public int compareTo(Action a){
        return this.priority - a.priority;
    }

}