package battletank.states;

import battletank.gfx.Assets;
import java.awt.Graphics;

public class MenuState extends State 
{

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.bg, 0, 0, null);
    }
    
}
