import java.awt.Color;
import java.util.ArrayList;

public class Game {

    public static Grid grid;
    public static Clock clock;

    protected static int score;
    private static int bgScore;

    public static int numEnermeyoSneks;

    private static ArrayList<Snek> enermeyoSneks = new ArrayList<Snek>();

    protected static Snek player1Snek;
    protected static Snek player2Snek;

    protected static Text scoreText;
    protected static Text enermyText;

    protected static Box box;

    public static void start() {

        score = 0;
        bgScore = 0;
        numEnermeyoSneks = 0;

        Engine.setSize(Settings.getSetting("Grid Length") * 2 + 10, Settings.getSetting("Grid Width") * 2 + 90);

        grid = new Grid(5, 5, Settings.getSetting("Grid Width"), Settings.getSetting("Grid Length"));

        clock = new Clock(Settings.getSetting("Tick Delay"));

        scoreText = new Text(Settings.getSetting("Grid Width") * 2 + 15, 8, 10, "", Color.black);

        Keyboard.addAction("die", new Action(100) {
            void act() {
                Game.clock.pause(); // stop the clock
                Clock.delay(1000);

                Engine.removeAllPixelComponents();
                Keyboard.clear();

                Main.startScreen();
            }
        });
        Keyboard.updateBinding(27, "die");

        clock.schedule(new Action(100) {
            void act() {
                if (bgScore >= 5) {

                    int x = 0;
                    int y = 0;

                    while (grid.getCell(x, y) != 0) {
                        x = (int) (Math.random() * Settings.getSetting("Grid Width"));
                        y = (int) (Math.random() * Settings.getSetting("Grid Length"));
                    }

                    enermeyoSneks.add(
                            new Snek(x, y, (int) (Math.random() * 4) + 1, false, Settings.getSetting("Snek Size"), 3));
                    bgScore -= 5;
                    numEnermeyoSneks++;
                }
                if (Settings.getSetting("Game Mode (0 coop, 1 battle)              ") == 0) {
                    scoreText.setText("Score: " + score);
                }
            }
        });

        Engine.addPixelComponent(scoreText);

        enermyText = new Text(Settings.getSetting("Grid Width") * 2 + 15, 16, 10, "Enermeyo: " + numEnermeyoSneks,
                Color.black);

        clock.schedule(new Action(100) {
            void act() {
                enermyText.setText("Enermeyo: " + numEnermeyoSneks);
            }
        });

        Engine.addPixelComponent(enermyText);

        box = new Box(Settings.getSetting("Grid Width") * 2 + 10, 5, 75, Engine.rows - 10, Color.lightGray);

        Engine.addPixelComponent(box);

        Engine.addPixelComponent(grid);

        if (Settings.getSetting("Number of Players") > 0) {
            player1Snek = new Snek(Settings.getSetting("Grid Width") * 2 / 3,
                    Settings.getSetting("Grid Length") * 2 / 3, Settings.getSetting("P1 Starting Direction"), true,
                    Settings.getSetting("Snek Size"), 4);
            bindToKeyboard(player1Snek, 1);
        }
        else{
            bgScore = 50;
        }


        if (Settings.getSetting("Number of Players") == 2) {
            player2Snek = new Snek(Settings.getSetting("Grid Width") / 3, Settings.getSetting("Grid Length") / 3,
                    Settings.getSetting("P2 Starting Direction"), true, Settings.getSetting("Snek Size"), 5);
            bindToKeyboard(player2Snek, 2);
        }

        int numApples = (int) ((double) Settings.getSetting("Permille of Apples") / 1000
                * Settings.getSetting("Grid Width") * Settings.getSetting("Grid Length"));

        for (int i = 0; i < numApples; i++) {
            grid.addApple();
        }

        clock.schedule(new Action(10000) {
            void act() {
                Engine.update();
            }
        });

        Engine.update();

        clock.start();

    }

    public static void scorePoint() {
        score++;
        bgScore++;
    }

    public static void bgScorePoint() {
        bgScore++;
    }

    public static void bindToKeyboard(Snek s, int playerNum) {

        Keyboard.addAction("up" + playerNum, new Action(0) {
            public void act() {
                s.changeDirection(1);
            } // turn up
        });

        Keyboard.addAction("right" + playerNum, new Action(0) {
            public void act() {
                s.changeDirection(2);
            } // turn right
        });

        Keyboard.addAction("down" + playerNum, new Action(0) {
            public void act() {
                s.changeDirection(3);
            } // turn down
        });

        Keyboard.addAction("left" + playerNum, new Action(0) {
            public void act() {
                s.changeDirection(4);
            } // turn left
        });

        Keyboard.updateBinding(Keyboard.getGameBinding("Player " + playerNum + " Left"), "left" + playerNum);
        Keyboard.updateBinding(Keyboard.getGameBinding("Player " + playerNum + " Up"), "up" + playerNum);
        Keyboard.updateBinding(Keyboard.getGameBinding("Player " + playerNum + " Right"), "right" + playerNum);
        Keyboard.updateBinding(Keyboard.getGameBinding("Player " + playerNum + " Down"), "down" + playerNum);

    }

    public static void end() {

        if (Settings.getSetting("Game Mode (0 coop, 1 battle)              ") == 0) {
            if (player1Snek.isDead() && (player2Snek != null && player2Snek.isDead())) {
                clock.schedule(new ShowCoopEnd());
                clock.setSpeed(30);
            }
            if (!player1Snek.isDead())
                player1Snek.dedify();
            if (player2Snek != null && !player2Snek.isDead())
                player2Snek.dedify();
        } else {
            if (!(player1Snek.isDead() && (player2Snek != null && player2Snek.isDead())))
                clock.schedule(new ShowBattleEnd());
            // clock.setSpeed(30);
        }

    }

}

class ShowCoopEnd extends Action {

    ShowCoopEnd() {
        super(10000);
        Game.clock.deSchedule(this);
    }

    void act() {
        if (Game.player1Snek.gone() && (Game.player2Snek == null || Game.player2Snek.gone())) {

            Game.clock.pause(); // stop the clock
            Clock.delay(1000);

            // remove everything
            Engine.removeAllPixelComponents();

            Engine.setSize(34, 80);

            Engine.addPixelComponent(new Text(3, 3, "Game Over!", Color.pink));
            Engine.addPixelComponent(new Text(3, 11, "Your Score Was: " + Game.score, Color.white));
            Engine.addPixelComponent(new Text(3, 19, "Press any key to", Color.lightGray));
            Engine.addPixelComponent(new Text(3, 26, "return to menu.", Color.lightGray));

            Engine.update();

            Keyboard.clear();

            Keyboard.waitForAnyKey();

            Engine.removeAllPixelComponents();

            Main.startScreen();

        }
    }

}

class ShowBattleEnd extends Action {

    ShowBattleEnd() {
        super(10000);
        Game.clock.deSchedule(this);
    }

    void act() {
        if (Game.player1Snek.gone() || (Game.player2Snek != null && Game.player2Snek.gone())) {
            Game.clock.pause(); // stop the clock
            Clock.delay(1000);

            // remove everything
            Engine.removeAllPixelComponents();

            Engine.setSize(34, 80);

            if (Game.player1Snek.isDead() && (Game.player2Snek == null || !Game.player2Snek.isDead())) {
                Engine.addPixelComponent(new Text(3, 3, "Green snek bad ", Color.blue));
                Engine.addPixelComponent(new Text(3, 11, "blue snek dab", Color.blue));
            } else if (Game.player1Snek.isDead() && Game.player2Snek.isDead()) {
                Engine.addPixelComponent(new Text(3, 3, "Blue Snek bad ", Color.yellow));
                Engine.addPixelComponent(new Text(3, 11, "Green Snek also bad", Color.yellow));
            } else {
                Engine.addPixelComponent(new Text(3, 3, "Blue Snek bad", Color.green));
                Engine.addPixelComponent(new Text(3, 11, "green snek dab", Color.green));
            }

            Engine.addPixelComponent(new Text(3, 19, "Press any key to", Color.lightGray));
            Engine.addPixelComponent(new Text(3, 26, "return to menu.", Color.lightGray));

            Engine.update();

            Keyboard.clear();

            Keyboard.waitForAnyKey();

            Engine.removeAllPixelComponents();

            Main.startScreen();

        }

    }

}