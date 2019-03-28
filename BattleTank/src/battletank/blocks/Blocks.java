package battletank.blocks;

import battletank.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Blocks 
{
    protected static final int TILEWIDTH = 32
                            ,TILEHEIGHT = 32;
    protected BufferedImage texture;
    protected final int id;
    protected int x,y;
    
    public Blocks(BufferedImage texture, int id)
    {
        this.id = id;
        this.texture = texture;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public int getId() { return id; }
    public int getX() { return x; }
    public int getY() { return y; }
}
