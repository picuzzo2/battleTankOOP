
package battletank.blocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BrickBlock extends Blocks
{
    public BrickBlock(BufferedImage texture, int id) 
    {
        super(texture, id);
        x = 10;
        y = 10;
    }

    @Override
    public void tick() 
    {
        
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(texture, x * TILEWIDTH, y* TILEHEIGHT, TILEWIDTH, TILEHEIGHT, null);
    }

}
