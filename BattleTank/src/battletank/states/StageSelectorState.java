package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.ui.ClickListener;
import battletank.ui.UIImageButton;
import battletank.ui.UIManager;
import battletank.ui.UIObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class StageSelectorState extends State
{
    private UIManager selectUI;
    private UIObject btn1,btn2,btn3,btn4,btn5;
    private BufferedImage show;

    public StageSelectorState(Game game) 
    {
        super(game);
        show = Assets.btn_11;
        selectUI = new UIManager(game);
        
        //back
        selectUI.addObject(new UIImageButton(570, 570, 49, 49, Assets.btn_back, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
        
        //stg1
        selectUI.addObject(btn1 = new UIImageButton(100, 450, 49, 49, Assets.btn1, new ClickListener(){
            @Override
            public void onClick() {
                game.getMenuState().setStage("res/world/world1.txt");
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
        
        //stg2
        selectUI.addObject(btn2 = new UIImageButton(200, 450, 49, 49, Assets.btn2, new ClickListener(){
            @Override
            public void onClick() {
                game.getMenuState().setStage("res/world/world2.txt");
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
        
        //stg3
        selectUI.addObject(btn3 =new UIImageButton(300, 450, 49, 49, Assets.btn3, new ClickListener(){
            @Override
            public void onClick() {
                game.getMenuState().setStage("res/world/world3.txt");
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
        
        //stg4
        selectUI.addObject(btn4 = new UIImageButton(400, 450, 49, 49, Assets.btn4, new ClickListener(){
            @Override
            public void onClick() {
                game.getMenuState().setStage("res/world/world4.txt");
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
        
        //stg5
        selectUI.addObject(btn5 = new UIImageButton(500, 450, 49, 49, Assets.btn5, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
        
    }
    
    private void showImage()
    {
        if(btn1.isHovering())
            show = Assets.IceStage;
        else if(btn2.isHovering())
            show = Assets.MazeStage;
        else if(btn3.isHovering())
            show = Assets.btn_32;
        else if(btn4.isHovering())
            show = Assets.btn_42;
        else if(btn5.isHovering())
            show = Assets.btn_52;
    }

    @Override
    public void tick() 
    {
        selectUI.tick();
        showImage();
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.startBg, 0, 0, 640, 640, null);
        g.drawImage(Assets.glassPanal, (640/2) - 110, 200, 220, 220, null);
        g.drawImage(show, (640/2) - 100 + 2, 212 , 195, 195, null);
        selectUI.render(g);
    }
    
    //getters
    public UIManager getUIManager() { return selectUI; }
    
}
