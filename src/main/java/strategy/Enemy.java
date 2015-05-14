package strategy;

import java.awt.*;

/**
 * Created by strel on 14.05.15.
 */
public class Enemy extends MovingObject {

    public Enemy(int x, int y, int v, World world) {
        super(x, y, v, 2, world);
    }

    @Override
    public void draw(Graphics g) {
        int sx = 4;
        int sy = 0;

        chooseLeg();
        sx = getSpriteX(sx);
        sy = getSpriteY(sy);

        g.drawImage(Game.getSpriteSheet(), x, y, x + 6, y + 6, sx * 6, sy * 6, sx * 6 + 6, sy * 6 + 6, null);
    }
}
