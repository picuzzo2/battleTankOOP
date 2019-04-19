
package battletank.bullets;

import battletank.gfx.Assets;
import battletank.world.World;
import static battletank.world.World.bullets;
import java.awt.Graphics;

public class Bullet 
{
    private final int PIX_WIDE = 32;
    private float x,y;
    private int direction;
    private int speed;
    private int xBlock, yBlock;
    private World world;
    private int enemy;
    
    public Bullet(float x, float y, int direction, World world, int player)
    {      
        this.direction = direction;
        this.world = world;
        this.speed = 7;
        switch(player)
        {
            case 1:
                enemy = 2;
                break;
            case 2:
                enemy = 1;
                break;
        }
        
        switch(direction)
        {
            case 0:
                this.x = x+13;
                this.y = y;
                break;
            case 1:
                this.x = x+26;
                this.y = y+13;
                break;
            case 2:
                this.x = x+13;
                this.y = y+26;
                break;
            case 3:
                this.x = x;
                this.y = y+13;
                break;
        }
    }
    
    public void tick()
    {
        //up=0, right=1, down=2, left=3
        set_checkBlock();
        switch(direction)
        {
            case 0: 
                if(!world.b[xBlock][yBlock].solid)
                    y -= speed;
                else 
                {
                    bullets.remove(this);
                    world.hitBlock(xBlock,yBlock);
                }
                
                if(hitPlayer())
                {
                    bullets.remove(this);
                    world.hitPlayer(enemy);
                    //System.out.println(y + " >= " + (world.getPlayer(enemy).getY() + 26)+ " <= " + world.getPlayer(enemy).getY());
                    //System.out.println("Hit player " + enemy);
                }
                break;
                
            case 1: 
                if(!world.b[xBlock][yBlock].solid)
                    x += speed;
                else 
                {
                    bullets.remove(this);
                    world.hitBlock(xBlock,yBlock);
                }
                
                if(hitPlayer())
                {
                    bullets.remove(this);
                    world.hitPlayer(enemy);
                    //System.out.println(y + " >= " + (world.getPlayer(enemy).getY() + 26)+ " <= " + world.getPlayer(enemy).getY());
                    //System.out.println("Hit player " + enemy);
                }
                break;
                
            case 2: 
                if(!world.b[xBlock][yBlock].solid)
                    y += speed;
                else 
                {
                    bullets.remove(this);
                    world.hitBlock(xBlock,yBlock);
                }
                
                if(hitPlayer())
                {
                    bullets.remove(this);
                    world.hitPlayer(enemy);
                    //System.out.println(y + " >= " + (world.getPlayer(enemy).getY() + 26)+ " <= " + world.getPlayer(enemy).getY());
                    //System.out.println("Hit player " + enemy);
                }
                break;
                
            case 3: 
                if(!world.b[xBlock][yBlock].solid)
                    x -= speed;
                else
                {
                    bullets.remove(this);
                    world.hitBlock(xBlock,yBlock);
                }
                
                if(hitPlayer())
                {
                    bullets.remove(this);
                    world.hitPlayer(enemy);
                    //System.out.println(y + " >= " + (world.getPlayer(enemy).getY() + 26)+ " <= " + world.getPlayer(enemy).getY());
                    //System.out.println("Hit player " + enemy);
                }
                break;
        }
    }

    public void set_checkBlock() 
    {
        switch(direction)
        {
            case 0:
                xBlock = (int)(x/PIX_WIDE);
                yBlock = (int)(y/PIX_WIDE);
                break;
            case 1:
                xBlock = (int)(x/PIX_WIDE);
                yBlock = (int)(y/PIX_WIDE);
                break;
            case 2:
                xBlock = (int)(x/PIX_WIDE);
                yBlock = (int)(y/PIX_WIDE);
                break;
            case 3:
                xBlock = (int)(x/PIX_WIDE);
                yBlock = (int)(y/PIX_WIDE);
                break;
        }
        if(xBlock > 19)
            xBlock = 19;
        else if(xBlock < 0)
            xBlock = 0;
        else if(yBlock > 19)
            yBlock = 19;
        else if(yBlock < 0)
            yBlock = 0;
    }

    
    public boolean collisionWithBlock()
    {
        switch(direction)
        {
            case 0:
                return (y < (yBlock+1) *PIX_WIDE);
            case 1:
                return (x < (xBlock * PIX_WIDE));
            case 2:
                return (y < (yBlock * PIX_WIDE));
            case 3:
                return (x > (xBlock+1) * PIX_WIDE);
        }
        return false;
    }
    
    public boolean hitPlayer()
    {
        if(y <= world.getPlayer(enemy).getY() + 26 
                && y >= world.getPlayer(enemy).getY())
        {
            if( x >= world.getPlayer(enemy).getX()
                    && x <= world.getPlayer(enemy).getX() + 26)
            {
                return true;
            }
        }
        return false;
    }
        
    public void render(Graphics g)
    {
        switch(direction)
        {
            case 0:
                g.drawImage(Assets.bullet[0], (int)x-5, (int)y, 10, 30,  null);
                break;
            case 1:
                g.drawImage(Assets.bullet[1], (int)x, (int)y-5, 30, 10,  null);
                break;
            case 2:
                g.drawImage(Assets.bullet[2], (int)x-5, (int)y, 10, 30,  null);
                break;
            case 3:
                g.drawImage(Assets.bullet[3], (int)x, (int)y-5, 30, 10,  null);
                break;
        }
        tick();
    }

}
