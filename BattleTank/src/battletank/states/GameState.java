package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.ui.ClickListener;
import battletank.ui.UIImageButton;
import battletank.ui.UIManager;
import battletank.world.World;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameState extends State {
    
    private boolean pause;
    private World world;
    private UIManager uiManager;
    

    public GameState(Game game, String path)
    {
        super(game);
        world = new World(path,game);
        uiManager = new UIManager(game);
        pause = false;
        
        //resume
        uiManager.addObject(new UIImageButton((640/2)-100+20, (640/2)-100+70, 160, 49, Assets.btn_resume, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(null);
                game.getKeyManager(1).getKeys()[KeyEvent.VK_ESCAPE] = false;
            }
        }));
        
        //menu exit
        uiManager.addObject(new UIImageButton((640/2)-100+20, (640/2)-100+125, 160, 49, Assets.btn_igexit, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
          
    }

    @Override
    public void tick() 
    {
        pause = game.getKeyManager(1).getKeys()[KeyEvent.VK_ESCAPE];
        
        if(!pause)
        {
            world.tick();
        }
        else
        {
            game.getMouseManager().setUIManager(uiManager);
            uiManager.tick();
        }
        
        
    }

    @Override
    public void render(Graphics g) 
    {
        world.render(g);
        if(pause)
        {
            g.drawImage(Assets.bluePanal,(640/2)-100, (640/2)-100, 200, 200, null);
            uiManager.render(g);
        }
        
    }

    //getters
    @Override
    public UIManager getUIManager() { return uiManager; }
    
    
    
}
