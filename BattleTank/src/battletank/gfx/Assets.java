package battletank.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
    public static BufferedImage penguin,pig,bg;
    
    public static void init()
    {
        penguin = ImgLoader.loadImage("/texture/penguin.png");
        pig = ImgLoader.loadImage("/texture/pig.png");
        bg = ImgLoader.loadImage("/texture/iceland.jpg");
    }
}
