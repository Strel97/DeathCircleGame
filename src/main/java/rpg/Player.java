package rpg;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by strel on 13.05.15.
 */
public class Player extends MovingObject {

    private InputHandler input;


    public Player(InputHandler input, int x, int y, int v) {
        super(x, y, v, 1);
        this.input = input;
    }

    @Override
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

        chooseLeg();
        sx = getSpriteX(sx);
        sy = getSpriteY(sy);

        g.drawImage(Game.getSpriteSheet(), x, y, x + 6, y + 6, sx * 6, sy * 6, sx * 6 + 6, sy * 6 + 6, null);
    }
}
