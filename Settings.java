import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Settings {

    private static HashMap<String, Integer> settings = new HashMap<String, Integer>();
    private static HashMap<String, Integer> settingsMax = new HashMap<String, Integer>();
    private static HashMap<String, Integer> settingsMin = new HashMap<String, Integer>();
    
    private static final String defaultSettings = "Visual Grid\n0\n0\n1\nTick Delay\n40\n100\n1000\nGrid Length\n12\n40\n100\nP2 Starting Direction\n1\n2\n4\nDifficulty\n0\n0\n1\nSnek Size\n2\n3\n999\nPermille of Apples\n1\n4\n50\nP1 Starting Direction\n1\n4\n4\nNumber of Players\n1\n2\n2\nGrid Width\n12\n40\n100\nSnek Turn Chance\n0\n30\n100\n";

    public static void readSettings() {
        Scanner scanner;
        String key;
        try {
            scanner = new Scanner(new File("settings.txt"));
        } catch (Exception e) {
            scanner = new Scanner(defaultSettings);
        }
        while (scanner.hasNextLine()) {
            key = scanner.nextLine();
            settingsMin.put(key, scanner.nextInt());
            settings.put(key, scanner.nextInt());
            settingsMax.put(key, scanner.nextInt());
            scanner.nextLine();
        }
        scanner.close();
    }

    public static int getSetting(String s) {
        return settings.get(s);
    }

    public static Set<String> getSettingList(){
        return settings.keySet();
    }

    public static boolean setSetting(String s, int newValue){
        if (newValue < getMinSetting(s) || newValue > getMaxSetting(s)){
            return false;
        }
        else{
            settings.put(s, newValue);
            return true;
        }
    }

    public static int getMinSetting(String s) {
        return settingsMin.get(s);
    }

    public static int getMaxSetting(String s) {
        return settingsMax.get(s);
    }

    public static void writeSettings() {
        try {
            PrintWriter writer = new PrintWriter("settings.txt");
            for (String s : settings.keySet()) {
                writer.println(s);
                writer.println(settingsMin.get(s));
                writer.println(settings.get(s));
                writer.println(settingsMax.get(s));
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void resetSettings(){
        File file = new File("settings.txt"); 
        file.delete();
        readSettings();
        writeSettings();
    }

}