import java.awt.*;

/**
 * Created by strel on 13.05.15.
 */
public class GameObject {

    protected Image img;
    protected int x, y;
    protected int v;


    public GameObject(Image img, int x, int y, int v) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.v = v;
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }
}
