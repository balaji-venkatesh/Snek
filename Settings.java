import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Settings{

    static HashMap<String,Integer> settings = new HashMap<String,Integer>();
    static String defaultSettings = "Visual Grid:0\nPlayer 1 Up:38\nPlayer 1 Right:39\nPlayer 1 Down:40\nPlayer 1 Left:37\nPlayer 2 Up:87\nPlayer 2 Right:68\nPlayer 2 Down:83\nPlayer 2 Left:65\nSnake Size:3\nGrid Width:45\nGrid Length:45\nTick Delay:100";

    public static void main(String[]args){
        readSettings();
        System.out.println(settings);
        System.out.println(getSetting("Snake Size"));
    }

    public static void readSettings(){
        Scanner scanner;
        try{
            scanner = new Scanner(new File("settings.txt"));
        } catch (Exception e){
            scanner = new Scanner(defaultSettings);
        }
         while(scanner.hasNextLine()){
            settings.put(scanner.nextLine(),scanner.nextInt());
            scanner.nextLine();
         }
         scanner.close();
    }
    
    public static int getSetting(String s){
        return settings.get(s);
    }

    
}