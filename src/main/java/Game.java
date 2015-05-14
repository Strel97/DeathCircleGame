import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 13.05.15.
 */
public class Game implements Runnable {

    private BufferedImage img = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
    private BufferedImage sprite_sheet = ResourceLoader.loadImage("/resources/sprites/sheet.png");

    private GameFrame frame;
    private InputHandler input;

    private Player player;

    private boolean running;


    public Game() {
        running = false;
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    public void init() {
        input = new InputHandler();

        frame = new GameFrame("Death Circle");
        frame.addKeyListener(input);

        player = new Player(
                input,
                ResourceLoader.loadImage("/sprites/player.png"),
                10, 10, 1);
    }

    @Override
    public void run() {

        init();

        while (running) {

            update();
            render();

            try {
                Thread.sleep(20);
            }
            catch (InterruptedException ex) { ex.printStackTrace(); }
        }
    }

    public void update() {
        player.step();
    }

    public void render() {
        BufferStrategy bs = frame.getBufferStrategy();
        if (bs == null) {
            frame.createBufferStrategy(2);
            bs = frame.getBufferStrategy();
            frame.requestFocus();
        }

        if (bs != null) {
            Graphics g = bs.getDrawGraphics();
            Graphics g2 = img.getGraphics();

            frame.render(g2);
            player.draw(g2);

            g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);

            g2.dispose();
            g.dispose();
            bs.show();
        }
    }


    public static void main(String[] args) {
        new Game().start();
    }
}
