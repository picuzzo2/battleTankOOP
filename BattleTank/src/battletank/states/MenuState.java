package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.ui.ClickListener;
import battletank.ui.UIImageButton;
import battletank.ui.UIManager;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.easyogg.OggClip;


public class MenuState extends State
{
    private UIManager menuUI;
    private GameState gameState;
    private String path;
    private OggClip menuMusic;

    public MenuState(Game game)
    {
        super(game);
        menuUI = new UIManager(game);
        game.getMouseManager().setUIManager(menuUI);
        path = "res/world/world1.txt";
        
        try {
            menuMusic = new OggClip("sound/menu.ogg");
        } catch (IOException ex) {
            Logger.getLogger(MenuState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        menuMusic.loop();
        
        //start
        menuUI.addObject(new UIImageButton(55, 160, 190, 49, Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                menuMusic.stop();
                gameState = new GameState(game,path);
                gameState.playBg();
                
                game.getMouseManager().setUIManager(null);
                game.getKeyManager(1).getKeys()[KeyEvent.VK_ESCAPE] = false;
                State.setState(gameState);
                System.out.println(path);
            }
        }));
        
        //stage
        menuUI.addObject(new UIImageButton(55, 220, 190, 49, Assets.btn_stage, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(game.getStageSelector().getUIManager());
                State.setState(game.getStageSelector());
            }
        }));
        
        //exit
        menuUI.addObject(new UIImageButton(55, 280, 190, 49, Assets.btn_exit, new ClickListener(){
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));

        
    }
    
    public void playBg()
    {
        menuMusic.loop();
    }
    
    public void setStage(String path)
    {
        this.path = path;
    }

    @Override
    public void tick() 
    {
        menuUI.tick();
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.startBg, 0, 0, 640, 640,  null);
        
        menuUI.render(g);
    }
    
    //getters
    @Override
    public UIManager getUIManager() { return menuUI; }
    public GameState getGameState() { return (GameState) gameState; }
}

