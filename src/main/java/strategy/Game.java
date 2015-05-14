package strategy;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 13.05.15.
 */
public class Game implements Runnable {

    private BufferedImage img = new BufferedImage(320, 320, BufferedImage.TYPE_INT_RGB);
    private static BufferedImage sprite_sheet = ResourceLoader.loadImage("/sprites/sheet.png");

    private GameFrame frame;
    private InputHandler input;

    private Map map;
    private World world;

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

        map = new Map(20, 20);
        map.loadMap(System.getProperty("user.dir") + "/src/main/resources/map.txt");

        world = new World();
        world.add( new Player(input, 110, 110, world) );
        world.add( new Enemy(150, 150, 1, world) );
        world.add( new Enemy(150, 150, 1, world) );
        world.add( new Enemy(150, 150, 1, world) );
    }

    @Override
    public void run() {

        init();

        while (running) {

            update();
            render();

            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) { ex.printStackTrace(); }
        }
    }

    public void update() {
        world.makeStep();
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
            map.draw(g2);

            world.draw(g2);

            g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);

            g2.dispose();
            g.dispose();
            bs.show();
        }
    }

    public static BufferedImage getSpriteSheet() {
        return sprite_sheet;
    }


    public static void main(String[] args) {
        new Game().start();
    }
}
