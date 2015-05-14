import java.awt.*;
import java.util.Random;

/**
 * Created by strel on 14.05.15.
 */
public abstract class MovingObject extends GameObject {

    protected Random rand;

    protected boolean moving;
    protected int direction;

    protected int sprite;
    protected boolean leftLeg;
    protected int walkedDistance;


    public MovingObject(int x, int y, int v, int sprite) {
        super(x, y, v);

        rand = new Random();

        moving = false;
        direction = 0;

        this.sprite = sprite;
        leftLeg = false;
        walkedDistance = 0;
    }

    public void step() {
        moving = true;
        if (walkedDistance % 10 == 0) {
            direction = rand.nextInt(Directions.SIDES_CNT);
        }

        if (moving) {
            walkedDistance += v;

            switch (direction) {
                case Directions.WEST:
                    x -= v;
                    break;

                case Directions.EAST:
                    x += v;
                    break;

                case Directions.NORTH:
                    y -= v;
                    break;

                case Directions.SOUTH:
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
            case Directions.SOUTH:
                sy = 0;
                break;

            case Directions.NORTH:
                sy = 1;
                break;

            case Directions.EAST:
                sy = 2;
                break;

            case Directions.WEST:
                sy = 3;
                break;
        }

        return sy;
    }

    @Override
    public abstract void draw(Graphics g);
}
