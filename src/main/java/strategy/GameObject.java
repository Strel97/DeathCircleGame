package strategy;

import java.awt.*;

/**
 * Created by strel on 13.05.15.
 */
public abstract class GameObject {

    public World world;
    protected int x, y;


    public GameObject(int x, int y, World world) {
        this.world = world;
        this.x = x;
        this.y = y;
    }

    public abstract void step();
    public abstract void draw(Graphics g);
}
