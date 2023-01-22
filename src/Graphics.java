import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {
    private Timer timer = new Timer(100, this);
    public String state;
    private Snake snake;
    private Food food;
    private Game game;

    public Graphics(Game g) {
        timer.start();
        state = "START";
        game = g;
        snake = g.getPlayer();
        food = g.getFood();

        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(Color.black);
        graphics2D.fillRect(0, 0, Game.width * Game.dimension + 5, Game.height * Game.dimension + 5);

        if (state.equals("START")) {
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString("Press any key", Game.width / 2 * Game.dimension - 40,
                    Game.height / 2 * Game.dimension - 20);
        } else if (state.equals("RUNNING")) {
            graphics2D.setColor(Color.red);
            graphics2D.fillRect(food.getX() * Game.dimension, food.getY() * Game.dimension, Game.dimension, Game.dimension);

            graphics2D.setColor(Color.green);
            for (Rectangle r : snake.getBody()) {
                graphics2D.fill(r);

            }
        } else {
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString("Your Score is: " + (snake.getBody().size() - 3), Game.width / 2 * Game.dimension - 40,
                    Game.height / 2 * Game.dimension - 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }
}
