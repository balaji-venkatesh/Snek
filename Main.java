import java.awt.Color;

public class Main {

    public static void main(String[] args) {

        Settings.readSettings(); // get settings from settings.txt
        Engine.showWindow("Snek"); // shows window

        showMenu(); // start main menu
    }

    public static void showMenu() {

        Engine.setSize(30, 91);

        Logo snek = new Logo(12, 2, 30);
        Text key = new Text(1, 22, "Press any key to start.", Color.darkGray);

        Engine.addPixelComponent(snek);
        Engine.addPixelComponent(key);

        Engine.update();

        Keyboard.waitForAnyKey();

        Engine.removePixelComponent(snek);
        Engine.removePixelComponent(key);

        Clock.delay(10);

        Game.start();

    }

    public void showSettings() {

    }

}