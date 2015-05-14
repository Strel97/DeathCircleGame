package strategy;

import java.awt.*;

/**
 * Created by strel on 15.05.15.
 */
public class Lumbermill extends Building {

    public Lumbermill(int x, int y, World world) {
        super(x, y, world);
    }

    @Override
    public void step() {

    }

    @Override
    public void draw(Graphics g) {
        int sx = 0;
        int sy = 4;
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
