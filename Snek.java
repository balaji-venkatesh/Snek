import java.util.ArrayList;

public class Snek {

    ArrayList<Integer> snekX = new ArrayList<Integer>(); // coordinates
    ArrayList<Integer> snekY = new ArrayList<Integer>();

    private int prevDirection;
    private int direction; // 1 is up, 2 is right, 3 is down, 4 is left
    private int colour;

    private static int numPlayerSneks;
    public static int numEnermeyoSneks;

    private boolean isPlayer;

    private int currentSize;
    private int size;

    public Snek(int x, int y, int dir, boolean isP, int s) {

        snekX.add(x);
        snekY.add(y);

        prevDirection = dir;
        direction = dir;
        isPlayer = isP;
        currentSize = 1;
        size = s;

        if (isP) {
            numPlayerSneks++;
            colour = numPlayerSneks + 4;
        } else {
            numEnermeyoSneks++;
            colour = 3;
        }

        Game.grid.setCell(x, y, colour);

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

        if (isPlayer)
            bindToKeyboard();

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
            if (Math.random() < (double) Settings.getSetting("Snek Turn Chance") / 100) // small chance of changing direction
                changeDirection((int) (Math.random() * 3) + 1);
        }
        if (size >= currentSize) { // if head needs to move forward, add new block in front
            add(snekX.get(0), snekY.get(0));
        } else
            currentSize--; // otherwise, don't move head forward and it will shrink
    }

    public boolean checkCollision(int x, int y) {
        if (Game.grid.getCell(x, y) > 1) {
            return false; // ded
        } else if (Game.grid.getCell(x, y) == 1) {
            // System.out.println("apple");
            size++;
            Game.grid.addApple();
            if (isPlayer){
                Game.score++;
                Game.bgScore++;
            }
            else if (Settings.getSetting("Difficulty") == 1 ){
                Game.bgScore++;
            }

        }
        return true; // everything ok
    }

    public void add(int x, int y) {
        add(x, y, 0);
    }

    public void add(int x, int y, int counter) {
        if (direction == 1) { // if facing up
            if (checkCollision(x, y - 1)) {
                snekX.add(0, x);
                snekY.add(0, y - 1);
            } else {
                dealWithCollision(x, y, counter);
            }
        } else if (direction == 2) { // if facing right
            if (checkCollision(x + 1, y)) {
                snekX.add(0, x + 1);
                snekY.add(0, y);
            } else {
                dealWithCollision(x, y, counter);
            }
        } else if (direction == 3) { // if facing down
            if (checkCollision(x, y + 1)) {
                snekX.add(0, x);
                snekY.add(0, y + 1);
            } else {
                dealWithCollision(x, y, counter);
            }
        } else { // if facing left
            if (checkCollision(x - 1, y)) {
                snekX.add(0, x - 1);
                snekY.add(0, y);
            } else {
                dealWithCollision(x, y, counter);
            }
        }
        Game.grid.setCell(snekX.get(0), snekY.get(0), colour);
    }

    public void dealWithCollision(int x, int y, int counter) {
        if (!isPlayer && counter < 100) {
            changeDirection((int) (Math.random() * 4) + 1);
            add(x, y, counter + 1);
        } else {
            dedify();
        }
    }

    public void dedify() {
        size = 0;
        currentSize--;
        for (int i = 0; i < snekX.size(); i++) {
            Game.grid.setCell(snekX.get(i), snekY.get(i), 8);
        }
        if (isPlayer)
            numPlayerSneks--;
        else
            numEnermeyoSneks--;
    }

    public void bindToKeyboard() {

        Keyboard.addAction("up" + numPlayerSneks, new Action(0) {
            public void act() {
                changeDirection(1);
            } // turn up
        });

        Keyboard.addAction("right" + numPlayerSneks, new Action(0) {
            public void act() {
                changeDirection(2);
            } // turn right
        });

        Keyboard.addAction("down" + numPlayerSneks, new Action(0) {
            public void act() {
                changeDirection(3);
            } // turn down
        });

        Keyboard.addAction("left" + numPlayerSneks, new Action(0) {
            public void act() {
                changeDirection(4);
            } // turn left
        });

        Keyboard.updateBinding(Settings.getSetting("Player " + numPlayerSneks + " Left"), "left" + numPlayerSneks);
        Keyboard.updateBinding(Settings.getSetting("Player " + numPlayerSneks + " Up"), "up" + numPlayerSneks);
        Keyboard.updateBinding(Settings.getSetting("Player " + numPlayerSneks + " Right"), "right" + numPlayerSneks);
        Keyboard.updateBinding(Settings.getSetting("Player " + numPlayerSneks + " Down"), "down" + numPlayerSneks);

    }

    public void changeDirection(int direction) {
        if ((prevDirection - direction) % 2 != 0)
            this.direction = direction;
    }

}