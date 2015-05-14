package strategy;

import java.awt.*;
import java.util.Random;

/**
 * Created by strel on 14.05.15.
 */
public abstract class MovingObject extends GameObject {

    protected Random rand;

    protected int v;
    protected boolean moving;
    protected int direction;

    protected int sprite;
    protected boolean leftLeg;
    protected int walkedDistance;


    public MovingObject(int x, int y, int v, int sprite, World world) {
        super(x, y, world);

        rand = new Random();

        this.v = v;
        moving = false;
        direction = 0;

        this.sprite = sprite;
        leftLeg = false;
        walkedDistance = 0;
    }

    public void step() {
        moving = true;
        if (walkedDistance % 10 == 0) {
            direction = rand.nextInt(strategy.Directions.SIDES_CNT);
        }

        if (moving) {
            walkedDistance += v;

            switch (direction) {
                case rpg.Directions.WEST:
                    x -= v;
                    break;

                case rpg.Directions.EAST:
                    x += v;
                    break;

                case rpg.Directions.NORTH:
                    y -= v;
                    break;

                case rpg.Directions.SOUTH:
                    y += v;
                    break;
            }
        }
    }

    protected boolean chooseLeg() {
        if (walkedDistance % 5 == 0)
            leftLeg = !leftLeg;

        return leftLeg;
    }

    protected int getSpriteX(int sx) {
        if (moving) {
            sx = (leftLeg) ? sx + 2 : sx + 1;
        }
        else {
            sx = sprite;
        }

        return sx;
    }

    protected int getSpriteY(int sy) {
        switch (direction) {
            case rpg.Directions.SOUTH:
                sy = 0;
                break;

            case rpg.Directions.NORTH:
                sy = 1;
                break;

            case rpg.Directions.EAST:
                sy = 2;
                break;

            case Directions.WEST:
                sy = 3;
                break;
        }

        return sy;
    }
}
