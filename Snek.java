import java.util.ArrayList;

public class Snek {

    ArrayList<Integer> snekX = new ArrayList<Integer>(); // coordinates
    ArrayList<Integer> snekY = new ArrayList<Integer>();

    private int prevDirection; // used to prevent 180 degrees
    private int direction; // 1 is up, 2 is right, 3 is down, 4 is left

    private int colour; // based on the color array defined in grid

    private boolean isPlayer; // is this snek a playerSnek?

    private int currentSize; // adaptive sizing
    private int size;

    public Snek(int x, int y, int direction, boolean isPlayer, int size, int colour) {

        // set variables
        this.prevDirection = direction;
        this.direction = direction;
        this.isPlayer = isPlayer;
        this.size = size;
        this.colour = colour;

        // set first block
        snekX.add(x);
        snekY.add(y);
        Game.grid.setCell(x, y, colour);
        currentSize = 1;

        // add actions, always calculate tail before head
        Game.clock.schedule(new Action(-10) {
            public void act() {
                updateTail();
            }
        });
        Game.clock.schedule(new Action(10) {
            public void act() {
                updateHead();
            }
        });

    }

    public void updateTail() {
        if (size <= currentSize && currentSize > 0) { // if tail needs to move forward, move it
            Game.grid.setCell(snekX.get(currentSize - 1), snekY.get(currentSize - 1), 0);
            snekX.remove(snekX.size() - 1);
            snekY.remove(snekY.size() - 1);
        } else // otherwise don't move tail and it will grow
            currentSize++;
    }

    public void updateHead() {
        prevDirection = direction; // used to prevent turning backward
        if (!isPlayer) {
            if (Math.random() < (double) Settings.getSetting("Snek Turn Chance") / 100)
                changeDirection((int) (Math.random() * 3) + 1); // enermeyo can randomy change direction
        }
        if (size >= currentSize && currentSize > 0) { // if head needs to move forward, add new block in front
            add(snekX.get(0), snekY.get(0));
        } else
            currentSize--; // otherwise, don't move head forward and it will shrink
    }

    public boolean checkCollision(int x, int y) {
        if (Game.grid.getCell(x, y) > 1) // collision has occured
            return false;
        else if (Game.grid.getCell(x, y) == 1) { // got an apple!
            size++;
            Game.grid.addApple(); // request new apple
            if (isPlayer)
                Game.scorePoint(); // get a point if a player
            else if (Settings.getSetting("Difficulty") == 1)
                Game.bgScorePoint();
            /*
             * if enermeyoSneks can get their own points, as per the difficulty setting,
             * then increase the background score count
             */
        }
        return true; // everything ok
    }

    public void add(int x, int y) {
        add(x, y, 0); // start recursive method (recursion is used for collision avoidance)
    }

    public void add(int x, int y, int counter) {
        if (direction == 1 && checkCollision(x, y - 1)) { // if facing up
            snekX.add(0, x);
            snekY.add(0, y - 1);
        }
        else if (direction == 2 && checkCollision(x + 1, y)) { // if facing right
            snekX.add(0, x + 1);
            snekY.add(0, y);
        }
        else if (direction == 3 && checkCollision(x, y + 1)) { // if facing down
            snekX.add(0, x);
            snekY.add(0, y + 1);
        }
        else if (direction == 4 && checkCollision(x - 1, y)) { // if facing left
            snekX.add(0, x - 1);
            snekY.add(0, y);
        }
        else
            dealWithCollision(x, y, counter);
        if (size > 0)
            Game.grid.setCell(snekX.get(0), snekY.get(0), colour);
    }

    public void dealWithCollision(int x, int y, int counter) {
        if (!isPlayer && counter < 100) { // collision avoidance AI
            changeDirection((int) (Math.random() * 4) + 1);
            add(x, y, counter + 1);
        } else
            dedify(); // kill the snek
    }

    public void dedify() {
        size = 0; // set intended size to 0
        currentSize--;
        for (int i = 0; i < snekX.size(); i++) // set all blocks to gray
            Game.grid.setCell(snekX.get(i), snekY.get(i), 6);
        if (isPlayer)
            Game.end();
    }

    public void changeDirection(int direction) {
        if ((prevDirection - direction) % 2 != 0) // prevent turning backward
            this.direction = direction;
    }

    public boolean isDead(){
        return size <= 0;
    }

    public boolean gone(){
        return currentSize <=0;
    }

}