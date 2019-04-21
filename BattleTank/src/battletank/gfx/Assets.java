package battletank.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
    public static BufferedImage iceTile,brickTile,waterTile,airTile
            , IceStage, MazeStage, defaultStage, flatStage;
    public static BufferedImage penguinp10, penguinp11, penguinp12, penguinp13
            , penguinp21, penguinp22, penguinp23, penguinp20
            , startBg, logo 
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
            , panal, bluePanal, glassPanal, panalOver
            , panalP1win, panalP2win
            , btn_resume1, btn_resume2
            , btn_igexit1, btn_igexit2
            , btn_backtomenu1, btn_backtomenu2;
    public static BufferedImage heart;
    public static BufferedImage[] btn_start, btn_stage, btn_exit, btn_back, btn_backtomenu;
    public static BufferedImage[] bullet, hearts ,player1, player2;
    public static BufferedImage[] btn1, btn2, btn3, btn4, btn5, btn_resume, btn_igexit;
    

   
    
    
    public static void init()
    {
        flatStage = ImgLoader.loadImage("/ui/flatStage.png");
        defaultStage = ImgLoader.loadImage("/ui/DefaultStage.png");
        IceStage = ImgLoader.loadImage("/ui/IceStage.png");
        MazeStage = ImgLoader.loadImage("/ui/MazeStage.png");
        
        panalP1win = ImgLoader.loadImage("/ui/panal_p1win.png");
        panalP2win = ImgLoader.loadImage("/ui/panal_p2win.png");
        
        logo = ImgLoader.loadImage("/ui/LoGo.png");
        heart = ImgLoader.loadImage("/texture/heart_animated_1.png");
        
        pan0 = ImgLoader.loadImage("/texture/pan.png");
        pan1 = ImgLoader.loadImage("/texture/pan1.png");
        pan2 = ImgLoader.loadImage("/texture/pan2.png");
        pan3 = ImgLoader.loadImage("/texture/pan3.png");
        
        startBg = ImgLoader.loadImage("/ui/menuBg.png");
        
        startButton1 =  ImgLoader.loadImage("/ui/btn_start1.png");
        startButton2 =  ImgLoader.loadImage("/ui/btn_start2.png");
        
        stageButton1 =  ImgLoader.loadImage("/ui/btn_stage1.png");
        stageButton2 =  ImgLoader.loadImage("/ui/btn_stage2.png");
        
        exitButton1 = ImgLoader.loadImage("/ui/btn_exit1.png");
        exitButton2 = ImgLoader.loadImage("/ui/btn_exit2.png");
        
        backBtn1 = ImgLoader.loadImage("/ui/btn_back1.png");
        backBtn2 = ImgLoader.loadImage("/ui/btn_back2.png");
        
        btn_backtomenu1 = ImgLoader.loadImage("/ui/btn_backtomenu1.png");
        btn_backtomenu2 = ImgLoader.loadImage("/ui/btn_backtomenu2.png");
        
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
        glassPanal = ImgLoader.loadImage("/ui/glassPanal.png");
        panalOver = ImgLoader.loadImage("/ui/panal_over.png");
        
        btn_resume1 = ImgLoader.loadImage("/ui/btn_resume1.png");
        btn_resume2 = ImgLoader.loadImage("/ui/btn_resume2.png");
        
        btn_igexit1 = ImgLoader.loadImage("/ui/btn_igexit1.png");
        btn_igexit2 = ImgLoader.loadImage("/ui/btn_igexit2.png");
        
        iceTile = ImgLoader.loadImage("/texture/IceTile.jpg");
        airTile = ImgLoader.loadImage("/texture/AirTile.jpg");
        waterTile = ImgLoader.loadImage("/texture/waterTile.png");
        brickTile = ImgLoader.loadImage("/texture/BrickTile.jpg");
        
        
        penguinp10 = ImgLoader.loadImage("/texture/player10.jpg");
        penguinp11 = ImgLoader.loadImage("/texture/player11.jpg");
        penguinp12 = ImgLoader.loadImage("/texture/player12.jpg");
        penguinp13 = ImgLoader.loadImage("/texture/player13.jpg");
        penguinp20 = ImgLoader.loadImage("/texture/player20.jpg");
        penguinp21 = ImgLoader.loadImage("/texture/player21.jpg");
        penguinp22 = ImgLoader.loadImage("/texture/player22.jpg");
        penguinp23 = ImgLoader.loadImage("/texture/player23.jpg");
        
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
        
        btn_backtomenu = new BufferedImage[2];
        btn_backtomenu[0] = btn_backtomenu1;
        btn_backtomenu[1] = btn_backtomenu2;
        
        hearts = new BufferedImage[2];
        hearts[0] = heart.getSubimage(0,0,17,17);
        hearts[1] = heart.getSubimage(4*17,0,17,17);
        
        player1 = new BufferedImage[4];
        player1[0] = penguinp10;
        player1[1] = penguinp11;
        player1[2] = penguinp12;
        player1[3] = penguinp13;
        
        player2 = new BufferedImage[4];
        player2[0] = penguinp20;
        player2[1] = penguinp21;
        player2[2] = penguinp22;
        player2[3] = penguinp23;
        
        
        
    }
}
