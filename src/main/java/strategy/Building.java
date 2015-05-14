package strategy;


/**
 * Created by strel on 15.05.15.
 */
public abstract class Building extends GameObject {

    protected int size;


    public Building(int x, int y, World world) {
        super(x, y, world);
        size = MapObjects.TILE_SIZE;
    }
}
