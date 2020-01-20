import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static int pos;
    private static String[] settingNames = {};
    private static String[] keyBindings = {};

    public static void main(String[] args) {

        Settings.readSettings(); // get settings from settings.txt
        Settings.writeSettings(); // write settings to settings.txt

        Keyboard.readGameBindings(); // get game bindings from keyboard.txt
        Keyboard.writeGameBindings(); // write game bindings to keyboard.txt

        Engine.showWindow("Snek"); // shows window

        startScreen(); // start main menu
    }

    public static void startScreen() {

        Engine.setSize(30, 91);

        Logo snek = new Logo(12, 2, 30);
        Text key = new Text(1, 22, "Press any key to start.", Color.darkGray);

        Engine.addPixelComponent(snek);
        Engine.addPixelComponent(key);

        Engine.update();

        Keyboard.waitForAnyKey();

        Engine.removeAllPixelComponents();

        settingsScreen();

    }

    public static void settingsScreen() {

        Clock.delay(10);

        Engine.setSize(55, 150);

        settingNames = Settings.getSettingList().toArray(settingNames);

        pos = 0;

        Engine.addPixelComponent(new Text(49, 2, "Game Settings", Color.yellow)); // title
        Engine.addPixelComponent(new Box(49, 1, -100, 53, 8, Color.darkGray)); // titlebox

        Engine.addPixelComponent(new Text(1, 14, "<A", Color.white)); // left
        Engine.addPixelComponent(new Text(140, 14, "D>", Color.white)); // right

        Engine.addPixelComponent(new Text(1, 26, "Use A&D or <&> to scroll", Color.darkGray));
        Engine.addPixelComponent(new Text(1, 33, "Use W&S or /\\ & \\/ to change settings", Color.darkGray));
        Engine.addPixelComponent(new Text(1, 40, "Press del to reset all settings", Color.darkGray));
        Engine.addPixelComponent(new Text(1, 47, "Press enter to continue", Color.white));

        Text setting = new Text(14, 11, settingNames[pos] + " (" + Settings.getMinSetting(settingNames[pos]) + " - "
                + Settings.getMaxSetting(settingNames[pos]) + ")", Color.white);
        Text value = new Text(14, 18, Settings.getSetting(settingNames[pos]) + "", Color.white);

        Engine.addPixelComponent(setting);
        Engine.addPixelComponent(value);

        Engine.update();

        Keyboard.addAction("startGame", new Action(0) {
            void act() {
                Keyboard.clear();
                Engine.removeAllPixelComponents();
                Settings.writeSettings();
                keyBindingScreen();
            }
        });
        Keyboard.updateBinding(10, "startGame");

        Keyboard.addAction("nextSetting", new Action(0) {
            void act() {
                if (pos < settingNames.length - 1)
                    pos++;
                else
                    pos = 0;
                setting.setText(settingNames[pos] + " (" + Settings.getMinSetting(settingNames[pos]) + " - "
                        + Settings.getMaxSetting(settingNames[pos]) + ")");
                value.setText(Settings.getSetting(settingNames[pos]) + "");
                Engine.update();
            }
        });
        Keyboard.updateBinding(68, "nextSetting");
        Keyboard.updateBinding(39, "nextSetting");

        Keyboard.addAction("previousSetting", new Action(0) {
            void act() {
                if (pos > 0)
                    pos--;
                else
                    pos = settingNames.length - 1;
                setting.setText(settingNames[pos] + " (" + Settings.getMinSetting(settingNames[pos]) + " - "
                        + Settings.getMaxSetting(settingNames[pos]) + ")");
                value.setText(Settings.getSetting(settingNames[pos]) + "");
                Engine.update();
            }
        });
        Keyboard.updateBinding(65, "previousSetting");
        Keyboard.updateBinding(37, "previousSetting");

        Keyboard.addAction("upSetting", new Action(0) {
            void act() {
                if (Settings.getSetting(settingNames[pos]) < Settings.getMaxSetting(settingNames[pos]))
                    Settings.setSetting(settingNames[pos], Settings.getSetting(settingNames[pos]) + 1);
                else
                    Settings.setSetting(settingNames[pos], Settings.getMinSetting(settingNames[pos]));
                value.setText(Settings.getSetting(settingNames[pos]) + "");
                Engine.update();
            }
        });
        Keyboard.updateBinding(38, "upSetting");
        Keyboard.updateBinding(87, "upSetting");

        Keyboard.addAction("downSetting", new Action(0) {
            void act() {
                if (Settings.getSetting(settingNames[pos]) > Settings.getMinSetting(settingNames[pos]))
                    Settings.setSetting(settingNames[pos], Settings.getSetting(settingNames[pos]) - 1);
                else
                    Settings.setSetting(settingNames[pos], Settings.getMaxSetting(settingNames[pos]));
                value.setText(Settings.getSetting(settingNames[pos]) + "");
                Engine.update();
            }
        });
        Keyboard.updateBinding(40, "downSetting");
        Keyboard.updateBinding(83, "downSetting");

        Keyboard.addAction("resetSetting", new Action(0) {
            void act() {
                Keyboard.clear();
                Settings.resetSettings();
                Engine.removeAllPixelComponents();
                settingsScreen();
            }
        });
        Keyboard.updateBinding(127, "resetSetting");

    }

    public static void keyBindingScreen() {

        Clock.delay(10);

        Engine.setSize(55, 150);

        ArrayList<String> kb = new ArrayList<String>(Keyboard.getGameBindings());

        Collections.sort(kb);

        keyBindings = kb.toArray(keyBindings);

        pos = 0;

        Engine.addPixelComponent(new Text(41, 2, "Keyboard Bindings", Color.yellow)); // title
        Engine.addPixelComponent(new Box(41, 1, -100, 69, 8, Color.darkGray)); // titlebox

        Engine.addPixelComponent(new Text(1, 14, "<A", Color.white)); // left
        Engine.addPixelComponent(new Text(140, 14, "D>", Color.white)); // right

        Engine.addPixelComponent(new Text(1, 26, "Use A&D or <&> to scroll", Color.darkGray));
        Engine.addPixelComponent(new Text(1, 33, "Press S or down to change a binding", Color.darkGray));
        Engine.addPixelComponent(new Text(1, 40, "Press del to reset all bindings", Color.darkGray));
        Engine.addPixelComponent(new Text(1, 47, "Press enter to start the game", Color.white));

        Text setting = new Text(14, 11, keyBindings[pos], Color.white);
        Text value = new Text(14, 18, Keyboard.keyName(keyBindings[pos]), Color.white);

        Engine.addPixelComponent(setting);
        Engine.addPixelComponent(value);

        Engine.update();

        Keyboard.addAction("startGame", new Action(0) {
            void act() {
                Engine.removeAllPixelComponents();
                Keyboard.writeGameBindings();
                gameScreen();
            }
        });
        Keyboard.updateBinding(10, "startGame");

        Keyboard.addAction("nextSetting", new Action(0) {
            void act() {
                if (pos < keyBindings.length - 1)
                    pos++;
                else
                    pos = 0;
                setting.setText(keyBindings[pos]);
                value.setText(Keyboard.keyName(keyBindings[pos]));
                Engine.update();
            }
        });
        Keyboard.updateBinding(68, "nextSetting");
        Keyboard.updateBinding(39, "nextSetting");

        Keyboard.addAction("previousSetting", new Action(0) {
            void act() {
                if (pos > 0)
                    pos--;
                else
                    pos = keyBindings.length - 1;
                setting.setText(keyBindings[pos]);
                value.setText(Keyboard.keyName(keyBindings[pos]));
                Engine.update();
            }
        });
        Keyboard.updateBinding(65, "previousSetting");
        Keyboard.updateBinding(37, "previousSetting");

        Keyboard.addAction("resetSetting", new Action(0) {
            void act() {
                Keyboard.clear();
                Keyboard.resetGameBindings();
                Engine.removeAllPixelComponents();
                keyBindingScreen();
            }
        });
        Keyboard.updateBinding(127, "resetSetting");

        Keyboard.addAction("getBinding", new Action(0) {
            void act() {
                Clock.delay(10);
                value.setText("press a key");
                System.out.println("waiting for key");
                int newKey = Keyboard.waitForAnyKey();
                System.out.println("got key");
                Keyboard.setGameBinding(keyBindings[pos], newKey);
                value.setText(Keyboard.keyName(keyBindings[pos]));
                Engine.update();
            }
        });
        Keyboard.updateBinding(40, "getBinding"); //

    }

    public static void gameScreen() {
        Keyboard.clear();
        Game.start();
    }

}