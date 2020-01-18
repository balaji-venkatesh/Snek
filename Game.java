import java.awt.Color;
import java.util.ArrayList;

public class Game {

    public static Grid grid;
    public static Clock clock;

    protected static int score = 0;
    private static int bgScore = 0;

    private static int numEnermeyoSneks = 0;

    private static ArrayList<Snek> enermeyoSneks = new ArrayList<Snek>();

    protected static Snek player1Snek;
    protected static Snek player2Snek;

    protected static Text scoreText;
    protected static Text enermyText;

    protected static Box box;

    public static void start() {

        Engine.setSize(Settings.getSetting("Grid Length") * 2 + 10, Settings.getSetting("Grid Width") * 2 + 90);

        grid = new Grid(5, 5, Settings.getSetting("Grid Width"), Settings.getSetting("Grid Length"));

        clock = new Clock(Settings.getSetting("Tick Delay"));

        scoreText = new Text(Settings.getSetting("Grid Width") * 2 + 15, 8, 10, "Score: 0", Color.black);

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
                            new Snek(x, y, (int) (Math.random() * 3) + 1, false, Settings.getSetting("Snek Size"), 3));
                    bgScore -= 5;
                    numEnermeyoSneks++;
                }
                scoreText.setText("Score: " + score);
            }
        });

        Engine.addPixelComponent(scoreText);

        enermyText = new Text(Settings.getSetting("Grid Width") * 2 + 15, 16, 10, "Enermeyo: 0", Color.black);

        clock.schedule(new Action(100) {
            void act() {
                enermyText.setText("Enermeyo: " + numEnermeyoSneks);
            }
        });

        Engine.addPixelComponent(enermyText);

        box = new Box(Settings.getSetting("Grid Width") * 2 + 10, 5, 75, 90, Color.lightGray);

        Engine.addPixelComponent(box);

        Engine.addPixelComponent(grid);

        clock.schedule(new Action(10000) {
            void act() {
                Engine.update();
            }
        });

        player1Snek = new Snek(Settings.getSetting("Grid Width") * 2 / 3, Settings.getSetting("Grid Length") * 2 / 3,
                Settings.getSetting("Player 1 Starting Direction"), true, Settings.getSetting("Snek Size"), 4);
        bindToKeyboard(player1Snek, 1);

        if (Settings.getSetting("Number of Players") == 2) {
            player2Snek = new Snek(Settings.getSetting("Grid Width") / 3, Settings.getSetting("Grid Length") / 3,
                    Settings.getSetting("Player 2 Starting Direction"), true, Settings.getSetting("Snek Size"), 5);
            bindToKeyboard(player2Snek, 2);
        }

        for (int i = 0; i < Settings.getSetting("Num of Apples"); i++)
            grid.addApple();

        clock.start(); // starts the game ticks

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

        Keyboard.updateBinding(Settings.getSetting("Player " + playerNum + " Left"), "left" + playerNum);
        Keyboard.updateBinding(Settings.getSetting("Player " + playerNum + " Up"), "up" + playerNum);
        Keyboard.updateBinding(Settings.getSetting("Player " + playerNum + " Right"), "right" + playerNum);
        Keyboard.updateBinding(Settings.getSetting("Player " + playerNum + " Down"), "down" + playerNum);

    }

    public static void end() {

        if (!player1Snek.isDead())
            player1Snek.dedify();
        if (player2Snek != null && !player2Snek.isDead())
            player2Snek.dedify();

        for (Snek s : enermeyoSneks) {
            s.dedify();
        }

        clock.schedule(new ShowEnd());

    }

}

class ShowEnd extends Action {

    ShowEnd() {
        super(10000);
        Game.clock.deSchedule(this);
    }

    void act() {
        if (Game.player1Snek.gone() && Game.player2Snek.gone()) {
            Game.clock.pause(); // stop the clock
            Clock.delay(100);

            // remove everything
            Engine.removePixelComponent(Game.grid);
            Engine.removePixelComponent(Game.scoreText);
            Engine.removePixelComponent(Game.enermyText);
            Engine.removePixelComponent(Game.box);

            Engine.setSize(34, 80);

            Text doneText = new Text(3, 3, "Game Over!", Color.pink);
            Text newScoreText = new Text(3, 11, "Your Score Was: " + Game.score, Color.white);
            Text continueText = new Text(3, 19, "Press any key to", Color.lightGray);
            Text continueText2 = new Text(3, 26, "return to menu.", Color.lightGray);

            Engine.addPixelComponent(doneText);
            Engine.addPixelComponent(newScoreText);
            Engine.addPixelComponent(continueText);
            Engine.addPixelComponent(continueText2);

            Engine.update();

            Keyboard.waitForAnyKey();

            Engine.removePixelComponent(doneText);
            Engine.removePixelComponent(newScoreText);
            Engine.removePixelComponent(continueText);
            Engine.removePixelComponent(continueText2);

            Main.showMenu();

        }
    }

}