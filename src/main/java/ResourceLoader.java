import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by strel on 13.05.15.
 */
public class ResourceLoader {

    public static BufferedImage loadImage(String filename) {
        BufferedImage img = null;

        try {
            File file = new File(System.getProperty("user.dir") + "/src/main/resources" + filename);
            if (file.exists())
                img = ImageIO.read(file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return img;
    }
}
