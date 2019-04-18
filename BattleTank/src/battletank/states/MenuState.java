package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.ui.ClickListener;
import battletank.ui.UIImageButton;
import battletank.ui.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class MenuState extends State
{
    private UIManager uiManager;

    public MenuState(Game game)
    {
        super(game);
        uiManager = new UIManager(game);
        game.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UIImageButton(200, 200, 100, 100, Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                game.getMouseManager().setUIManager(null);
                State.setState(game.getGameState());
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
        uiManager.render(g);
    }

}

