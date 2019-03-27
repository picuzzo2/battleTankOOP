package battletank.blocks;

import java.awt.image.BufferedImage;

public class Blocks 
{
    private static final int TILEWIDTH = 30
                            ,TILEHEIGHT = 30;
    protected BufferedImage texture;
    protected final int id;
    
    public Blocks(BufferedImage texture, int id)
    {
        this.id = id;
        this.texture = texture;
    }
    
    public void tick()
    {
        
    }
    
    public void render()
    {
        
    }
    
    public int getId() { return id; }
}
