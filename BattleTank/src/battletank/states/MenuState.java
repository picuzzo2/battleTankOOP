package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import java.awt.Graphics;

public class MenuState extends State 
{
    public MenuState(Game game)
    {
        super(game);
    }


    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.bg, 0, 0, null);
        g.drawImage(Assets.playBt, 450, 200, 100,100, null);
    }
    
}



