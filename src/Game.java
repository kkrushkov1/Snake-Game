import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class Game implements KeyListener {

    private Snake player;
    private Food food;
    private Graphics graphics;

    private JFrame window;
    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;

    public Game() {
        window = new JFrame();

        player = new Snake();
        food = new Food(player);
        graphics = new Graphics(this);

        window.add(graphics);
        window.setTitle("Snake");
        window.setSize(width * dimension + 2, height * dimension + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // used to center to my computer
    }

    public void start() {
        graphics.state = "RUNNING";
    }

    public void restart(){
        Game game = new Game();
    }


    public void update() {
        if (graphics.state.equals("RUNNING")) {
            if (checkFoodCollision()) {
                player.grow();
                food.randomSpawn(player);
            } else if (checkWallCollision() || checkSelfCollision()) {
                graphics.state = "END";
            } else {
                player.move();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(Objects.equals(graphics.state, "RUNNING")) {
            if(keyCode == KeyEvent.VK_W && !Objects.equals(player.getCurrentMove(), "DOWN")) {
                player.up();
            }

            if(keyCode == KeyEvent.VK_S && !Objects.equals(player.getCurrentMove(), "UP")) {
                player.down();
            }

            if(keyCode == KeyEvent.VK_A && !Objects.equals(player.getCurrentMove(), "RIGHT")) {
                player.left();
            }

            if(keyCode == KeyEvent.VK_D && !Objects.equals(player.getCurrentMove(), "LEFT")) {
                player.right();
            }
        }else if (graphics.state.equals("END")){
            this.restart();
        }else {
            this.start();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Snake getPlayer() {
        return player;
    }

    public Food getFood() {
        return food;
    }

    public JFrame getWindow() {
        return window;
    }

    private boolean checkWallCollision() {
        if (player.getX() < 0 || player.getX() >= width * dimension
                || player.getY() < 0 || player.getY() >= height * dimension) {
            return true;
        }
        return false;
    }

    private boolean checkFoodCollision() {
        if (player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension) {
            return true;
        }
        return false;
    }

    private boolean checkSelfCollision() {
        for (int i = 1; i < player.getBody().size(); i++) {
            if (player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y) {
                return true;
            }

        }
        return false;
    }

    private void setPlayer(Snake player) {
        this.player = player;
    }

    private void setFood(Food food) {
        this.food = food;
    }

    private void setWindow(JFrame window) {
        this.window = window;
    }
}
