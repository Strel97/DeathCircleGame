package strategy;

import javax.swing.*;
import java.awt.*;

/**
 * Created by strel on 13.05.15.
 */
public class GameFrame extends JFrame {

    private strategy.GamePanel canvas;


    public GameFrame(String caption) {
        super(caption);

        canvas = new strategy.GamePanel();

        setSize(canvas.getSize());

        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(
                screenDim.width / 2 - this.getSize().width / 2,
                screenDim.height / 2 - this.getSize().height / 2
        );

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void render(Graphics g) {
        canvas.render(g);
    }
}
