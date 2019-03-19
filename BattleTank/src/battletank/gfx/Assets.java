package battletank.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
    public static BufferedImage penguin;
    
    public static void init()
    {
        penguin = ImgLoader.loadImage("/texture/penguin.png");
    }
}
