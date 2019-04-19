package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.ui.ClickListener;
import battletank.ui.UIImageButton;
import battletank.ui.UIManager;
import java.awt.Graphics;

public class GameOverState extends State
{
    private UIManager uiManager;

    public GameOverState(Game game) 
    {
        super(game);
        uiManager = new UIManager(game);
        
        //back
        uiManager.addObject(new UIImageButton(570, 570, 49, 49, Assets.btn_back, new ClickListener(){
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
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) 
    {       
        g.drawImage(Assets.gameOver, 0, 0, null);
        uiManager.render(g);
    }

    @Override
    public UIManager getUIManager() 
    {
        return uiManager;
    }

}
