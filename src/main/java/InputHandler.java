import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by strel on 13.05.15.
 */
public class InputHandler implements KeyListener {

    private static final int MAX_KEYS = 256;


    private boolean[] keys;


    public InputHandler() {
        keys = new boolean[MAX_KEYS];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (validateKeyCode(keycode))
            keys[keycode] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (validateKeyCode(keycode))
            keys[keycode] = false;
    }

    public boolean isPressed(int keycode) {
        return validateKeyCode(keycode) && keys[keycode];
    }

    public boolean isMovingKeyPressed() {
        return keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_DOWN];
    }

    public void loadKeyConfig(String filename) {
        Properties prop = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);

        if (stream != null) {
            try {
                prop.load(stream);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }



    }

    private boolean validateKeyCode(int keycode) {
        return (keycode > 0) && (keycode < MAX_KEYS);
    }
}
