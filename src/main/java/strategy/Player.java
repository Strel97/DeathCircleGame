package strategy;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by strel on 13.05.15.
 */
public class Player extends Cursor {

    private InputHandler input;
    private int v;

    public Player(InputHandler input, int x, int y, World world) {
        super(x, y, world);
        this.input = input;
        v = MapObjects.TILE_SIZE;
    }

    @Override
    public void step() {
        if (input.isMovingKeyPressed()) {
            if (input.isPressed(KeyEvent.VK_LEFT)) {
                x -= v;
            } else if (input.isPressed(KeyEvent.VK_RIGHT)) {
                x += v;
            } else if (input.isPressed(KeyEvent.VK_UP)) {
                y -= v;
            } else if (input.isPressed(KeyEvent.VK_DOWN)) {
                y += v;
            }
        }
        else if (input.isPressed(KeyEvent.VK_SPACE)) {
            world.add(new Lumbermill(x, y, world));
        }
    }

    @Override
    public void draw(Graphics g) {
        int sx = 0;
        int sy = 2;
        int sTile = MapObjects.TILE_SIZE;

        g.drawImage(
                Game.getSpriteSheet(),
                x, y,
                x + sTile, y + sTile,
                sx * sTile, sy * sTile,
                sx * sTile + sTile, sy * sTile + sTile,
                null);
    }
}
