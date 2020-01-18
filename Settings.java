import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Settings{

    static HashMap<String,Integer> settings = new HashMap<String,Integer>();
    static String defaultSettings = "Visual Grid\n0\nPlayer 1 Starting Direction\n2\nPlayer 1 Up\n38\nPlayer 1 Right\n39\nPlayer 1 Down\n40\nPlayer 1 Left\n37\nPlayer 2 Starting Direction\n4\nPlayer 2 Up\n87\nPlayer 2 Right\n68\nPlayer 2 Down\n83\nPlayer 2 Left\n65\nSnek Size\n3\nGrid Width\n45\nGrid Length\n45\nTick Delay\n100\nNum of Apples\n50";

    public static void readSettings(){
        Scanner scanner;
        try{
            scanner = new Scanner(new File("settings.txt"));
            System.out.println("settings.txt");
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