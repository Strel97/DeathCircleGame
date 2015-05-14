import java.awt.*;

/**
 * Created by strel on 13.05.15.
 */
public class GamePanel extends Canvas {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;


    public GamePanel() {
        setSize(new Dimension(WIDTH, HEIGHT));
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
}
