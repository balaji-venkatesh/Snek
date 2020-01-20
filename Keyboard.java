import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Keyboard implements KeyListener {

    private static HashMap<Integer, String> bindings = new HashMap<Integer, String>();
    private static HashMap<String, Action> actions = new HashMap<String, Action>();

    private static HashMap<String, Integer> gameBindings = new HashMap<String, Integer>();

    private static volatile int lastPressed = 0;

    public static void addAction(String name, Action a) {
        actions.put(name, a);
    }

    public static void removeAction(String name) {
        bindings.values().removeIf(value -> value.equals(name));
        actions.remove(name);
    }

    public static void updateBinding(Integer keyCode, String name) {
        bindings.put(keyCode, name);
    }

    public static String bindingList() {
        String out = "";
        for (String s : actions.keySet()) {
            out += s + ": ";
            if (getKeyByValue(bindings, s) != null) {
                out += KeyEvent.getKeyText(getKeyByValue(bindings, s));
            } else
                out += "unbound";
        }
        return out;
    }

    public void keyPressed(KeyEvent e) {
        if (lastPressed == 0)
            lastPressed = e.getKeyCode();
        else {
            String name = bindings.getOrDefault(e.getKeyCode(), "");
            if (!name.equals("")) {
                new Thread() {
                    public void run() {
                        actions.get(name).act();
                    }
                }.start();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static int waitForAnyKey() {
        Clock.delay(10);
        lastPressed = 0;
        while (lastPressed == 0)
            Clock.delay(10);
        return lastPressed;
    }

    public static void readGameBindings() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("keyboard.txt"));
        } catch (Exception e) {
            scanner = new Scanner(
                    "Player 2 Left\n65\nPlayer 2 Down\n83\nPlayer 2 Right\n68\nPlayer 1 Left\n37\nPlayer 1 Up\n38\nPlayer 1 Right\n39\nPlayer 2 Up\n87\nPlayer 1 Down\n40\n");
        }
        while (scanner.hasNextLine()) {
            gameBindings.put(scanner.nextLine(), scanner.nextInt());
            scanner.nextLine();
        }
        scanner.close();
    }

    public static void writeGameBindings() {
        try {
            PrintWriter writer = new PrintWriter("keyboard.txt");
            for (String s : gameBindings.keySet()) {
                writer.println(s);
                writer.println(gameBindings.get(s));
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getGameBinding(String s) {
        return gameBindings.get(s);
    }

    public static void setGameBinding(String name, int keyCode) {
        //gameBindings.values().removeIf(value -> value.equals(keyCode)); // removes old bindings
        Set<String> keys = gameBindings.keySet();
        for(String key : keys){
            if(gameBindings.get(key) == keyCode){
                gameBindings.put(key, gameBindings.get(name));
            }
        }
        gameBindings.put(name, keyCode);
    }

    public static Set<String> getGameBindings() {
        return gameBindings.keySet();
    }

    public static String keyName(String s) {
        if (gameBindings.get(s) != null) {
            return KeyEvent.getKeyText(gameBindings.get(s));
        } else
            return "unbound";
    }

    public static void clear() {
        bindings = new HashMap<Integer, String>();
    }

    public static void resetGameBindings() {
        File file = new File("keyboard.txt");
        file.delete();
        readGameBindings();
        writeGameBindings();
    }

}