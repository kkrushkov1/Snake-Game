import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Snake {

    private ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;
    private String move;

    public Snake() {
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(d, d);
        temp.setLocation(w / 2 * d, h / 2 * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        body.add(temp);

        move = "NOTHING";
    }

    public void move() {
        if (!Objects.equals(move, "NOTHING")) {
            Rectangle first = body.get(0);
            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

            if (Objects.equals(move, "UP")) {
                temp.setLocation(first.x, first.y - Game.dimension);
            } else if (Objects.equals(move, "DOWN")) {
                temp.setLocation(first.x, first.y + Game.dimension);
            } else if (move.equals("LEFT")) {
                temp.setLocation(first.x - Game.dimension, first.y);
            } else {
                temp.setLocation(first.x + Game.dimension, first.y);
            }

            body.add(0, temp);
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
        Rectangle first = body.get(0);
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

        if (Objects.equals(move, "UP")) {
            temp.setLocation(first.x, first.y - Game.dimension);
        } else if (Objects.equals(move, "DOWN")) {
            temp.setLocation(first.x, first.y + Game.dimension);
        } else if (move.equals("LEFT")) {
            temp.setLocation(first.x - Game.dimension, first.y);
        } else {
            temp.setLocation(first.x + Game.dimension, first.y);
        }

        body.add(0, temp);
    }


    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }

    public void up() {
        if (!move.equals("DOWN")) {
            move = "UP";
        }
    }

    public void down() {
        if (!move.equals("UP")) {
            move = "DOWN";
        }
    }

    public void left() {
        if (!move.equals("RIGHT")) {
            move = "LEFT";
        }
    }

    public void right() {
        if (!move.equals("LEFT")) {
            move = "RIGHT";
        }
    }


}