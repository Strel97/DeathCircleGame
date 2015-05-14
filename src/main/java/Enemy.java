import java.awt.*;
import java.util.Random;

/**
 * Created by strel on 14.05.15.
 */
public class Enemy extends MovingObject {

    public Enemy(int x, int y, int v) {
        super(x, y, v, 2);
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
