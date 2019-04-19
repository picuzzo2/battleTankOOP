package battletank.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
    public static BufferedImage iceTile,brickTile,waterTile,airTile,testBrick,testWater,testAir,testIce;
    public static BufferedImage penguin, penguin_1, stageSelector, gameOver, startBg 
            ,pan0,pan1,pan2,pan3;
    public static BufferedImage startButton1,startButton2
            ,stageButton1,stageButton2
            ,exitButton1,exitButton2
            ,backBtn1, backBtn2;
    public static BufferedImage btn_11, btn_12
            , btn_21, btn_22
            , btn_31, btn_32
            , btn_41, btn_42
            , btn_51, btn_52
            , panal, bluePanal
            , btn_resume1, btn_resume2
            , btn_igexit1, btn_igexit2;
    public static BufferedImage[] btn_start, btn_stage, btn_exit, btn_back;
    public static BufferedImage[] bullet;
    public static BufferedImage[] btn1, btn2, btn3, btn4, btn5, btn_resume, btn_igexit;
   
    
    
    public static void init()
    {
        pan0 = ImgLoader.loadImage("/texture/pan.png");
        pan1 = ImgLoader.loadImage("/texture/pan1.png");
        pan2 = ImgLoader.loadImage("/texture/pan2.png");
        pan3 = ImgLoader.loadImage("/texture/pan3.png");
        
        stageSelector = ImgLoader.loadImage("/ui/stageSelector.png");
        startBg = ImgLoader.loadImage("/ui/startBg.png");
        gameOver = ImgLoader.loadImage("/texture/gameOver.png");
        
        startButton1 =  ImgLoader.loadImage("/ui/btn_start1.png");
        startButton2 =  ImgLoader.loadImage("/ui/btn_start2.png");
        
        stageButton1 =  ImgLoader.loadImage("/ui/btn_stage1.png");
        stageButton2 =  ImgLoader.loadImage("/ui/btn_stage2.png");
        
        exitButton1 = ImgLoader.loadImage("/ui/btn_exit1.png");
        exitButton2 = ImgLoader.loadImage("/ui/btn_exit2.png");
        
        backBtn1 = ImgLoader.loadImage("/ui/btn_back1.png");
        backBtn2 = ImgLoader.loadImage("/ui/btn_back2.png");
        
        btn_11 = ImgLoader.loadImage("/ui/btn_11.png");
        btn_12 = ImgLoader.loadImage("/ui/btn_12.png");
        btn_21 = ImgLoader.loadImage("/ui/btn_21.png");
        btn_22 = ImgLoader.loadImage("/ui/btn_22.png");
        btn_31 = ImgLoader.loadImage("/ui/btn_31.png");
        btn_32 = ImgLoader.loadImage("/ui/btn_32.png");
        btn_41 = ImgLoader.loadImage("/ui/btn_41.png");
        btn_42 = ImgLoader.loadImage("/ui/btn_42.png");
        btn_51 = ImgLoader.loadImage("/ui/btn_51.png");
        btn_52 = ImgLoader.loadImage("/ui/btn_52.png");
        panal = ImgLoader.loadImage("/ui/panal.png");
        bluePanal = ImgLoader.loadImage("/ui/panal_blue.png");
        
        btn_resume1 = ImgLoader.loadImage("/ui/btn_resume1.png");
        btn_resume2 = ImgLoader.loadImage("/ui/btn_resume2.png");
        
        btn_igexit1 = ImgLoader.loadImage("/ui/btn_igexit1.png");
        btn_igexit2 = ImgLoader.loadImage("/ui/btn_igexit2.png");
        
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
        
        btn_start = new BufferedImage[2];
        btn_start[0] = startButton1;
        btn_start[1] = startButton2;
        
        btn_stage = new BufferedImage[2];
        btn_stage[0] = stageButton1;
        btn_stage[1] = stageButton2;
        
        btn_exit = new BufferedImage[2];
        btn_exit[0] = exitButton1;
        btn_exit[1] = exitButton2;
        
        bullet = new BufferedImage[4];
        bullet[0] = pan0;
        bullet[1] = pan1;
        bullet[2] = pan2;
        bullet[3] = pan3;
        
        btn_back = new BufferedImage[2];
        btn_back[0] = backBtn1;
        btn_back[1] = backBtn2;
        
        btn1 = new BufferedImage[2];
        btn1[0] = btn_11;
        btn1[1] = btn_12;
        
        btn2 = new BufferedImage[2];
        btn2[0] = btn_21;
        btn2[1] = btn_22;
        
        btn3 = new BufferedImage[2];
        btn3[0] = btn_31;
        btn3[1] = btn_32;
        
        btn4 = new BufferedImage[2];
        btn4[0] = btn_41;
        btn4[1] = btn_42;
        
        btn5 = new BufferedImage[2];
        btn5[0] = btn_51;
        btn5[1] = btn_52;
        
        btn_resume = new BufferedImage[2];
        btn_resume[0] = btn_resume1;
        btn_resume[1] = btn_resume2;
        
        btn_igexit = new BufferedImage[2];
        btn_igexit[0] = btn_igexit1;
        btn_igexit[1] = btn_igexit2;
        
        
        
    }
}
