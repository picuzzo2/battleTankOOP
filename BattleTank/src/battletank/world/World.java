
package battletank.world;

import battletank.Game;
import battletank.blocks.AirBlock;
import battletank.blocks.Blocks;
import battletank.blocks.BrickBlock;
import battletank.blocks.GrassBlock;
import battletank.gfx.Assets;
import battletank.utils.Utils;
import java.awt.Graphics;

public class World 
{
    //20*20 block
    private static final int PIX_WIDE = 32;
    
    public Blocks[][] b = new Blocks[20][20];
    
    public World(String path)
    {
        loadWorld(path);
    }
    
    private void blockInit()
    {
        
        for(int i=0; i<20; i++)
        {
            for(int j=0; j<20; j++)
            b[i][j] = new GrassBlock(0,i,j);
        }
        for(int i=0; i<20; i++)
        {
            for(int j=0; j<20; j++)
            {
                
                if(i==0 || i==19 || j==0 || j==19)
                    b[i][j] = new BrickBlock(1,i,j);
            }
        }
        b[10][10] = new BrickBlock(1,10,10);
    }
    
    public void loadWorld(String path)
    {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        
        for(int y=0; y<20; y++)
        {
            for(int x=0; x<20; x++)
            {
                switch(Utils.parseInt(tokens[(x+y*20)]))
                {
                    case 0:
                        b[x][y] = new AirBlock(0,x,y);
                        break;
                    case 1:
                        b[x][y] = new GrassBlock(1,x,y);
                        break;
                    case 2:
                        b[x][y] = new BrickBlock(2,x,y);
                        break;
                }
            }
        }
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
        //showGrid(g);
    }
}
