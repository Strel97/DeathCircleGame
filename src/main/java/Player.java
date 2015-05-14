import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by strel on 13.05.15.
 */
public class Player extends GameObject {

    private InputHandler input;
    private boolean moving;
    private int direction;

    private long walkedDistance;
    private boolean leftLeg;


    public Player(InputHandler input, Image img, int x, int y, int v) {
        super(img, x, y, v);
        this.input = input;
        direction = Directions.SOUTH;
        moving = false;

        walkedDistance = 0;
        leftLeg = false;
    }

    public void step() {
        moving = false;

        if (input.isMovingKeyPressed()) {
            moving = true;
            walkedDistance += v;

            if (input.isPressed(KeyEvent.VK_LEFT)) {
                x -= v;
                direction = Directions.WEST;
            } else if (input.isPressed(KeyEvent.VK_RIGHT)) {
                x += v;
                direction = Directions.EAST;
            } else if (input.isPressed(KeyEvent.VK_UP)) {
                y -= v;
                direction = Directions.NORTH;
            } else if (input.isPressed(KeyEvent.VK_DOWN)) {
                y += v;
                direction = Directions.SOUTH;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        int sx = 0;
        int sy = 0;

        if (walkedDistance % 10 == 0)
            leftLeg = !leftLeg;

        if (moving) {
            sx = (leftLeg) ? 2 : 0;
        }
        else {
            sx = 1;
        }

        switch (direction) {
            case Directions.SOUTH:
                sy = 0;
                break;

            case Directions.WEST:
                sy = 1;
                break;

            case Directions.EAST:
                sy = 2;
                break;

            case Directions.NORTH:
                sy = 3;
                break;
        }

        g.drawImage(img, x, y, x + 32, y + 32, sx * 32, sy * 32, sx * 32 + 32, sy * 32 + 32, null);
    }
}
