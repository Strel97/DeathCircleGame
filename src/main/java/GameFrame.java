import javax.swing.*;
import java.awt.*;

/**
 * Created by strel on 13.05.15.
 */
public class GameFrame extends JFrame {

    private GamePanel canvas;


    public GameFrame(String caption) {
        super(caption);

        canvas = new GamePanel();

        setSize(canvas.getSize());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void render(Graphics g) {
        canvas.render(g);
    }
}
