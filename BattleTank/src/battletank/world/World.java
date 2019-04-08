
package battletank.world;

import battletank.Game;
import battletank.blocks.Blocks;
import battletank.blocks.BrickBlock;
import battletank.blocks.GrassBlock;
import battletank.gfx.Assets;
import java.awt.Graphics;

public class World 
{
    //20*20 block
    private static final int PIX_WIDE = 32;
    
    public Blocks[][] b = new Blocks[20][20];
    
    public World()
    {
        blockInit();
    }
    
    private void blockInit()
    {
        for(int i=0; i<20; i++)
        {
            for(int j=0; j<20; j++)
            b[i][j] = new GrassBlock(i,j);
        }
        for(int i=0; i<20; i++)
        {
            for(int j=0; j<20; j++)
            {
                
                if(i==0 || i==19 || j==0 || j==19)
                    b[i][j] = new BrickBlock(i,j);
            }
        }
    }
    
    public void loadWOrld(String path)
    {
        
    }
    
    public void collisionDetection()
    {
        
    }
    
    private void blockRender(Graphics g)
    {
        for(int x=0; x<20; x++)
        {
            for(int y=0; y<20; y++)
            {
                
                    try{
                    b[x][y].render(g);
                    } catch (Exception e){};
                
            }
        }
    }
    
    private void showGrid(Graphics g)
    {
        for(int i=0; i<20; i++)
        {
            g.drawLine(i* PIX_WIDE, 0* PIX_WIDE, i* PIX_WIDE, 20* PIX_WIDE);
            g.drawLine(0* PIX_WIDE, i* PIX_WIDE, 20* PIX_WIDE, i* PIX_WIDE);
        }
    }
    
    public Blocks[][] getBlock()
    {
        return b;
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g)
    {
        blockRender(g); 
        showGrid(g);
    }
}
