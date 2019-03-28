package battletank.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
    public static BufferedImage penguin,pig,bg,hippo;
    
    public static void init()
    {
        penguin = ImgLoader.loadImage("/texture/penguin.png");
        pig = ImgLoader.loadImage("/texture/pig.png");
        bg = ImgLoader.loadImage("/texture/iceland.jpg");
        hippo = ImgLoader.loadImage("/texture/hippo.png");
    }
}
