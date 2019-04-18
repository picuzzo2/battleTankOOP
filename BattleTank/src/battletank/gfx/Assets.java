package battletank.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
    public static BufferedImage iceTile,brickTile,waterTile,airTile,testBrick,testWater,testAir,testIce;
    public static BufferedImage penguin,penguin_1,bg;
    public static BufferedImage startButton,startButton2;
    public static BufferedImage[] btn_start;
    
    
    
    public static void init()
    {
        startButton2 =  ImgLoader.loadImage("/texture/startButton2.png");
        startButton =  ImgLoader.loadImage("/texture/startButton.png");
        testIce = ImgLoader.loadImage("/texture/testIce.jpg");
        testAir = ImgLoader.loadImage("/texture/testAir.jpg");
        testWater = ImgLoader.loadImage("/texture/testWater.jpg");
        testBrick = ImgLoader.loadImage("/texture/testBrick.jpg");
        //iceTile = ImgLoader.loadImage("/texture/IceTile.png");
        //brickTile = ImgLoader.loadImage("/texture/brickTile.png");
        //waterTile = ImgLoader.loadImage("/texture/waterTile.png");
        //airTile = ImgLoader.loadImage("/texture/airTile.png");
        
        penguin = ImgLoader.loadImage("/texture/penguin.png");
        penguin_1 = ImgLoader.loadImage("/texture/penguin_1.jpeg");
        
        bg = ImgLoader.loadImage("/texture/iceland.jpg");
        
        
        btn_start = new BufferedImage[2];
        btn_start[0] = startButton;
        btn_start[1] = startButton2;
        
        
    }
}
