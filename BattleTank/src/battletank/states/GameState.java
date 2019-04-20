package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.ui.ClickListener;
import battletank.ui.UIImageButton;
import battletank.ui.UIManager;
import battletank.world.World;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.easyogg.OggClip;

public class GameState extends State {
    
    private boolean pause,gameOver,playWin=false;
    private World world;
    private int winner;
    private UIManager pauseUI, gameOverUI;
    private OggClip gameBg,overBg;
    

    public GameState(Game game, String path)
    {
        super(game); 
        winner = 0;
        world = new World(path,game);
        pauseUI = new UIManager(game);
        gameOverUI = new UIManager(game);
        pause = false;
        gameOver = false;
        
        try {
            gameBg = new OggClip("sound/game.ogg");
            overBg = new OggClip("sound/over.ogg");
        } catch (IOException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //resume
        pauseUI.addObject(new UIImageButton((640/2)-100+20, (640/2)-100+70, 160, 49, Assets.btn_resume, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(null);
                game.getKeyManager(1).getKeys()[KeyEvent.VK_ESCAPE] = false;
            }
        }));
        
        //menu exit
        pauseUI.addObject(new UIImageButton((640/2)-100+20, (640/2)-100+125, 160, 49, Assets.btn_igexit, new ClickListener(){
            @Override
            public void onClick() {
                gameBg.stop();
                game.getMenuState().playBg();
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
        
        //return to menu
        gameOverUI.addObject(new UIImageButton((640/2)-65, (640/2)-100+80, 130, 40, Assets.btn_igexit, new ClickListener(){
            @Override
            public void onClick() {
                game.getMenuState().playBg();
                game.getMouseManager().setUIManager(game.getMenuState().getUIManager());
                State.setState(game.getMenuState());
            }
        }));
          
    }
    
    public void playBg()
    {
        gameBg.loop();
        
    }

    @Override
    public void tick() 
    {
        pause = game.getKeyManager(1).getKeys()[KeyEvent.VK_ESCAPE];
        
        if(!pause && !gameOver)
        {
            world.tick();
        }
        else if(pause && !gameOver)
        {
            game.getMouseManager().setUIManager(pauseUI);
            pauseUI.tick();
        }
        
        if(gameOver)
        {
            if(!playWin)
            {
                playWin = true;
                gameBg.stop();
                overBg.play();
            }
            game.getMouseManager().setUIManager(gameOverUI);
            gameOverUI.tick();
            
        }
        
        
    }

    @Override
    public void render(Graphics g) 
    {
        world.render(g);
        if(pause && !gameOver)
        {
            g.drawImage(Assets.bluePanal,(640/2)-100, (640/2)-100, 200, 200, null);
            pauseUI.render(g);
        }
        
        if(gameOver)
        {
            switch(winner)
            {
                case 1:
                    g.drawImage(Assets.panalP1win,(640/2)-100, (640/2)-100, null);
                    break;
                case 2:
                    g.drawImage(Assets.panalP2win,(640/2)-100, (640/2)-100, null);
                    break;
            }
            gameOverUI.render(g);
        }
        
    }

    //getters
    @Override
    public UIManager getUIManager() { return pauseUI; }
    public void setOver(boolean set)
    {
        gameOver = set;
            
    }
    
    public void setWinner(int p)
    {
        winner = p;
    }
    
    
    
}
