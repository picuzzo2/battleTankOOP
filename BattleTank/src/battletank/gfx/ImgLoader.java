package battletank.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImgLoader 
{
    public static BufferedImage loadImage(String path)
    {
        try {
            return ImageIO.read(ImgLoader.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(ImgLoader.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return null;
    }
}
