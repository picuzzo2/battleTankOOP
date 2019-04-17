package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import java.awt.Graphics;

public class GameOverState extends State
{

    public GameOverState(Game game) 
    {
        super(game);
    }

    @Override
    public void tick() 
    {
        
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.bg, 0, 0, null);
    }

}
