package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.ui.ClickListener;
import battletank.ui.UIImageButton;
import battletank.ui.UIManager;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class MenuState extends State
{
    private UIManager uiManager;

    public MenuState(Game game)
    {
        super(game);
        uiManager = new UIManager(game);
        game.getMouseManager().setUIManager(uiManager);
        
        //start
        uiManager.addObject(new UIImageButton((640/2)-(190/2), 200, 190, 49, Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(null);
                game.getKeyManager(1).getKeys()[KeyEvent.VK_ESCAPE] = false;
                State.setState(game.getGameState());
            }
        }));
        
        //stage
        uiManager.addObject(new UIImageButton((640/2)-(190/2), 300, 190, 49, Assets.btn_stage, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(game.getStageSelector().getUIManager());
                State.setState(game.getStageSelector());
            }
        }));
        
        //exit
        uiManager.addObject(new UIImageButton((640/2)-(190/2), 400, 190, 49, Assets.btn_exit, new ClickListener(){
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));
    }
    

    @Override
    public void tick() 
    {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.startBg, 0, 0, 640, 640,  null);
        uiManager.render(g);
    }
    
    //getters
    @Override
    public UIManager getUIManager() { return uiManager; }

}

