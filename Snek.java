import java.util.ArrayList;

public class Snek {

    ArrayList<Integer> snekX = new ArrayList<Integer>();
    ArrayList<Integer> snekY = new ArrayList<Integer>();

    private int direction; // 1 is up, 2 is right, 3 is down, 4 is left
    private int colour;

    private static int numPlayerSneks;

    private boolean isPlayer;

    private int size;
    private int totalSize;

    public Snek(int x, int y, int dir, boolean isP, int s) {

        snekX.add(x);
        snekY.add(y);

        direction = dir;
        isPlayer = isP;
        size = 1;
        totalSize = s;

        if (isP) {
            numPlayerSneks++;
            colour = numPlayerSneks + 4;
        } else {
            colour = 3;
        }

        Main.grid.setCell(x, y, colour);

        Main.clock.schedule(new Action(-10) {
            public void act(){
                updateTail();
            }
        });

        Main.clock.schedule(new Action(10) {
            public void act(){
                updateHead();
            }
        });

        addKeyBindings();

    }

    public void updatePos() {

        if(!(totalSize < size)){
            add(snekX.get(0), snekY.get(0), direction);
        } else size --;
        if(!(totalSize > size)){
            System.out.println(size);
            Main.grid.setCell(snekX.get(size - 1), snekY.get(size - 1), 0);
            snekX.remove(0);
            snekY.remove(0);
        } else size ++;

    }

    public void updateTail(){
        //System.out.println("totalsize" + totalSize + "size" + size);
        if(totalSize <= size){
            //System.out.println("tail" + this.colour);
            Main.grid.setCell(snekX.get(size - 1), snekY.get(size - 1), 0);
            snekX.remove(snekX.size()-1);
            snekY.remove(snekY.size()-1);
        } else size ++;

    }

    public void updateHead(){
        if(totalSize >= size){
            //System.out.println("head" + this.colour);
            add(snekX.get(0), snekY.get(0), direction);
        }
        else size--;
    }


    public void checkCollision(int x, int y) {
        if (Main.grid.getCell(x, y) > 1)
            totalSize = 0;
        else if (Main.grid.getCell(x, y) == 1) {
            System.out.println("apple");
            totalSize ++;
        }

    }

    public void add(int x, int y, int dir) {
        int currentX = x;
        int currentY = y;
        if (dir == 1) { // if facing up
            checkCollision(currentX, currentY - 1);
            snekX.add(0, currentX);
            snekY.add(0, currentY - 1);
        } else if (dir == 2) { // if facing right
            checkCollision(currentX + 1, currentY);
            snekX.add(0, currentX + 1);
            snekY.add(0, currentY);
        } else if (dir == 3) { // if facing down
            checkCollision(currentX, currentY + 1);
            snekX.add(0, currentX);
            snekY.add(0, currentY + 1);
        } else { // if facing left
            checkCollision(currentX - 1, currentY);
            snekX.add(0, currentX - 1);
            snekY.add(0, currentY);
        }
        Main.grid.setCell(snekX.get(0), snekY.get(0), colour);
    }

    public void addKeyBindings() {

        Keyboard.addAction("up", new Action(0) {public void act(){changeDirection(1);} //turn up
        });

        Keyboard.addAction("right", new Action(0) {public void act(){changeDirection(2);} //turn right
        });
        
        Keyboard.addAction("down", new Action(0) {public void act(){changeDirection(3);} //turn down
        });

        Keyboard.addAction("left", new Action(0) {public void act(){changeDirection(4);} //turn left
        });
        
        Keyboard.updateBinding(37, "left");
        Keyboard.updateBinding(38, "up");
        Keyboard.updateBinding(39, "right");
        Keyboard.updateBinding(40, "down");

        //System.out.println(Keyboard.bindingList());
        
    }

    public void changeDirection(int direction) {
        this.direction = direction;
    }

}