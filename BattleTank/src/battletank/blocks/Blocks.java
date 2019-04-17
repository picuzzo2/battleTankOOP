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

    public boolean moveAble = true;
    public boolean solid = false;
    
    public Blocks( int id, int x, int y)
    {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);

    public boolean isMoveAble() { return moveAble; }
    public int getID() { return id; }
}
