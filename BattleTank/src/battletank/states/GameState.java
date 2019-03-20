package battletank.states;

import battletank.gfx.Assets;
import java.awt.Graphics;

public class GameState extends State {

    public GameState(){}
    
    int x=0;
    @Override
    public void tick() 
    {
        x++;
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.penguin, x, x, null);
        
    }
    
}
