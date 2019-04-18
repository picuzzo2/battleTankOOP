
package battletank.world;

import battletank.Game;
import battletank.blocks.AirBlock;
import battletank.blocks.Blocks;
import battletank.blocks.BrickBlock;
import battletank.blocks.GrassBlock;
import battletank.blocks.IceBlock;
import battletank.blocks.WaterBlock;
import battletank.bullets.Bullet;
import battletank.gfx.Assets;
import battletank.player.Player;
import battletank.states.GameOverState;
import battletank.states.State;
import battletank.utils.Utils;
import java.awt.Graphics;
import java.util.LinkedList;

public class World 
{
    //20*20 block
    private static final int PIX_WIDE = 32;
    
    private Player player1,player2;
    public Blocks[][] b = new Blocks[20][20];
    public static LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    private State gameOver;
    
    public World(String path, Game game)
    {
        loadWorld(path);
        player1 = new Player(this,game, 10, 1, 1, Assets.penguin_1);
        player2 = new Player(this,game, 10, 18, 2, Assets.penguin );     
        gameOver = new GameOverState(game);
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
                        b[x][y] = new WaterBlock(1,x,y);
                        break;
                    case 2:
                        b[x][y] = new BrickBlock(2,x,y);
                        break;
                    case 3:
                        b[x][y] = new IceBlock(3,x,y);
                        break;
                }
            }
        }
    }
  
    public void hitPlayer(int p)
    {
        getPlayer(p).hit();
    }
    
    public void hitBlock(int x, int y)
    {
        //System.out.println("Hit Block ID : " + b[x][y].getID());
        if ( b[x][y].getID() == 3)
        {
            b[x][y] = new AirBlock(0,x,y);
        }
    }
    
    public void tick()
    {
        //player tick
        player1.tick();
        player2.tick();
        
        if(player1.getLife() <= 0 || player2.getLife() <= 0)
        {
            State.setState(gameOver);
        }
    }
    
    public void render(Graphics g)
    {
        
        //block render
        for(int x=0; x<20; x++)
        {
            for(int y=0; y<20; y++)
            {
                b[x][y].render(g);
            }
        }
        
        //bullet render + tick
        for(int i=0; i<bullets.size(); i++)
            bullets.get(i).render(g);
        
        //player render
        player1.render(g);
        player2.render(g);
        
        
    }
    
    public Player getPlayer(int p)
    {
        switch(p)
        {
            case 1:
                return player1;
            case 2:
                return player2;
            
        }
        return null;
    }
}