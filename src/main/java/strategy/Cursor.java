package strategy;

import java.awt.*;

/**
 * Created by strel on 14.05.15.
 */
public abstract class Cursor extends GameObject {

    public Cursor(int x, int y, World world) {
        super(x, y, world);
    }

    public abstract void step();
    public abstract void draw(Graphics g);
}
