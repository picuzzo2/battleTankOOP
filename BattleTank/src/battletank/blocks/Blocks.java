package battletank.blocks;

import battletank.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Blocks 
{
    public static final int PIX_WIDE =32;
    
    protected BufferedImage texture;
    protected final int id;
    protected int x,y;
    public int trX,trY
            ,tlX,tlY
            ,brX,brY
            ,blX,blY;
    public boolean moveAble = true;
    
    public Blocks( int id, int x, int y)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        tlX = x; tlY = y;
        trX = x+PIX_WIDE; trY = y;
        blX = x; blY = y+PIX_WIDE;
        brX = x+PIX_WIDE; brY = y+PIX_WIDE;
        
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);

    public boolean isMoveAble()
    {
        return moveAble;
    }
}
