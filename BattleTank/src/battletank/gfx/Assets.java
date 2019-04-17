package battletank.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
    public static BufferedImage penguin,pig,bg,hippo,parrot;
    public static BufferedImage brickblock,airblock,grassblock,iceblock;
    public static BufferedImage penguin10,penguin11,penguin12,penguin13;
    public static BufferedImage[] texture;
    public static BufferedImage[] player1;
    
    public static void init()
    {
        iceblock = ImgLoader.loadImage("/texture/brickblock_1.png");
        airblock = ImgLoader.loadImage("/texture/airblock.png");
        brickblock = ImgLoader.loadImage("/texture/brickblock.png");
        penguin = ImgLoader.loadImage("/texture/penguin.png");
        pig = ImgLoader.loadImage("/texture/pig.png");
        bg = ImgLoader.loadImage("/texture/iceland.jpg");
        hippo = ImgLoader.loadImage("/texture/hippo.png");
        parrot = ImgLoader.loadImage("/texture/parrot.png");
        
        penguin10 = ImgLoader.loadImage("/texture/penguin10_1.png");
        penguin11 = ImgLoader.loadImage("/texture/penguin11.png");
        penguin12 = ImgLoader.loadImage("/texture/penguin12.png");
        penguin13 = ImgLoader.loadImage("/texture/penguin13.png");
    }
}
