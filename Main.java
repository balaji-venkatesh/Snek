import java.awt.Color;

public class Main {

    public static void main(String[] args) {

        Settings.readSettings(); // get settings from settings.txt
        Engine.showWindow("Snek"); // shows window

        showMenu(); // start main menu

    }

    public static void showMenu() {

        Engine.setSize(30, 91);

        Text snek = new Text(15, 5, "Snek", Color.white);
        Text key = new Text(1, 23, "Press any key to start.", Color.darkGray);

        Engine.addPixelComponent(snek);
        Engine.addPixelComponent(key);

        Engine.update();

    }

    public void showSettings() {

    }

}