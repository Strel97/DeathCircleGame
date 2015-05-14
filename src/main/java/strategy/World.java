package strategy;

import java.awt.*;
import java.util.*;

/**
 * Created by strel on 15.05.15.
 */
public class World {

    private ArrayList<GameObject> objects;


    public World() {
        objects = new ArrayList<GameObject>();
    }

    public void add(GameObject obj) {
        objects.add(obj);
    }

    public void remove(GameObject obj) {
        objects.remove(obj);
    }

    public void makeStep() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).step();
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).draw(g);
        }
    }
}
