import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Keyboard implements KeyListener {

    private static HashMap<Integer, String> bindings = new HashMap<Integer, String>();
    private static HashMap<String, Action> actions = new HashMap<String, Action>();

    public static void addAction(String name, Action a) {
        actions.putIfAbsent(name, a);
    }

    public static void removeAction(String name) {
        bindings.values().removeIf(value -> value.equals(name));
        actions.remove(name);
    }

    public static void updateBinding(Integer keyCode, String name) {
        bindings.values().removeIf(value -> value.equals(name));
        bindings.put(keyCode, name);
    }

    public static void getBindingFromKeyBoard(String name) {

    }

    public static String bindingList() {
        String out = "";
        for (String s : actions.keySet()) {
            out += s + ": ";
            if (getKeyByValue(bindings, s) != null){
                out += KeyEvent.getKeyText(getKeyByValue(bindings, s));}
            else
                out += "unbound";
        }
        return out;
    }

    public void keyPressed(KeyEvent e) {
        String name = bindings.getOrDefault(e.getKeyCode(), "");
        if (!name.equals(""))
            actions.get(name).act();
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

}