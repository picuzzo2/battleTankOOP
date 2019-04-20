
package battletank.blocks;

import battletank.gfx.Assets;
import java.awt.Graphics;

public class AirBlock extends Blocks {

    public AirBlock( int id, int x, int y) 
    {
        super( id, x, y);
        texture = Assets.airTile;
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
