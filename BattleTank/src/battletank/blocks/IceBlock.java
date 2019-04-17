package battletank.blocks;

import battletank.gfx.Assets;
import java.awt.Graphics;

public class IceBlock extends Blocks
{

    public IceBlock(int id, int x, int y) 
    {
        super(id, x, y);
        super.solid = true;
        super.moveAble = false;
    }

    @Override
    public void tick() 
    {
        
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.iceblock, x * PIX_WIDE, y* PIX_WIDE, PIX_WIDE, PIX_WIDE , null);
        
    }
    
}
