
package battletank.blocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BrickBlock extends Blocks
{
    public BrickBlock(BufferedImage texture, int id, int x, int y) 
    {
        super(texture, id, x , y);       
        super.moveAble = false;
    }

    @Override
    public void tick() 
    {
        
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(texture, x * PIX_WIDE, y* PIX_WIDE, PIX_WIDE, PIX_WIDE , null);
    }

}
