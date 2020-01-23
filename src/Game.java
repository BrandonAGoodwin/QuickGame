import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Game implements KeyListener {

    private boolean playing;

    private int mapSize;
    private String[][] map;

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int xStart;
    private int yStart;


    private String player;
    private String floor;
    private String walls;


    public Game() {
        init();
        playing = true;
        Scanner s = new Scanner(System.in);
        String input;
        System.out.println("Game Started");
        while(playing) {
            input = s.nextLine();
            System.out.println(input);
            switch (input) {
                case "w":
                    moveUp();
                    break;
                case "a":
                    moveLeft();
                    break;
                case "s":
                    System.out.println("Movedown");
                    moveDown();
                    break;
                case "d":
                    moveRight();
                    break;
            }
            System.out.println("x : " + x + "\ty : " + y + "\ndx: " + dx + "\tdy: " + y);
            move();
            step();
        }

    }

    private void init() {
        mapSize = 10;
        map = new String[mapSize][mapSize];
        player = "O";
        floor = ".";
        walls = "#";

        xStart = mapSize - 2;
        yStart = mapSize - 2;
        fillMap();
    }

    private void fillMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = floor;
            }
        }

        x = xStart;
        y = yStart;
        map[x][y] = player;

    }

    private void step() {
        for (int row = 0; row < mapSize; row++) {
            System.out.println();
            for (int col = 0; col < mapSize; col++) {
                System.out.print(map[col][row]);
            }
        }


       // System.out.println("Stepping.");
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W) { moveUp(); }
        else if (keyCode == KeyEvent.VK_A) { moveLeft(); }
        else if (keyCode == KeyEvent.VK_S) { moveDown(); }
        else if (keyCode == KeyEvent.VK_D) { moveRight(); }
    }

    private void moveRight() {
        dx = x +1;
    }

    private void moveDown() {
        dy = y + 1;
    }

    private void moveLeft() {
        dx = x - 1;
    }

    private void moveUp() {
        dy = y - 1;
    }

    private void move() {
        map[x][y] = floor;
        map[dx][dy] = player;
        x = dx;
        y = dy;

    }

    public static void main(String [] args) {
        Game game = new Game();
    }

}