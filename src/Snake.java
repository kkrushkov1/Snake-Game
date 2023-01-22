import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Snake {

    private ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;
    private String currentMove;
    public int applesEaten = 0;

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

        currentMove = "NOTHING";
    }

    public void move() {
        if(!Objects.equals(currentMove, "NOTHING")) {
            Rectangle a = body.get(0);

            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

            if(Objects.equals(currentMove, "UP")) {
                temp.setLocation(a.x, a.y-Game.dimension);
                body.add(0, temp);
            }
            else if(Objects.equals(currentMove, "DOWN")) {
                temp.setLocation(a.x, a.y+Game.dimension);
                body.add(0, temp);
            }
            else if(Objects.equals(currentMove, "LEFT")) {
                temp.setLocation(a.x-Game.dimension, a.y);
                body.add(0, temp);
            }
            else {
                temp.setLocation(a.x+Game.dimension, a.y);
                body.add(0, temp);
            }

            body.remove(body.size()-1);
        }
    }

    public void grow() {
        Rectangle a = body.get(0);

        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

        if(Objects.equals(currentMove, "UP")) {
            temp.setLocation(a.x, a.y-Game.dimension);
            body.add(0, temp);
        }
        else if(Objects.equals(currentMove, "DOWN")) {
            temp.setLocation(a.x, a.y+Game.dimension);
            body.add(0, temp);
        }
        else if(Objects.equals(currentMove, "LEFT")) {
            temp.setLocation(a.x-Game.dimension, a.y);
            body.add(0, temp);
        }
        else {
            temp.setLocation(a.x+Game.dimension, a.y);
            body.add(0, temp);
        }
        applesEaten++;
    }

    public String getCurrentMove() {
        return currentMove;
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
        currentMove = "UP";
    }

    public void down() {
        currentMove = "DOWN";
    }

    public void left() {
        currentMove = "LEFT";
    }

    public void right() {
        currentMove = "RIGHT";
    }


}
