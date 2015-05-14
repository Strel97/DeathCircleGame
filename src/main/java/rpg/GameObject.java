package rpg;

import java.awt.*;

/**
 * Created by strel on 13.05.15.
 */
public abstract class GameObject {

    protected int x, y;
    protected int v;


    public GameObject(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

    public abstract void draw(Graphics g);
}
