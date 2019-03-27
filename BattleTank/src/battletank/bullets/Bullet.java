
package battletank.bullets;

import battletank.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet 
{
  
    private BufferedImage bl;
    private float x,y;
    private int direction;
    private int speed;
    private boolean bulletReady ;
    private int bulletTime;
    
    
    public Bullet(float x, float y, int direction)
    {      
        bulletTime = 0;
        speed = 10;
        this.x = x;
        this.y = y;
        bl = Assets.pig;
        this.direction = direction;
        bulletReady = false;
    }
    
    public boolean isReady()
    {
        return bulletReady;
    }
    
    public boolean hit()
    {
        switch(direction)
        {
            case 0: if( y < 0) return true;
            else return false;
            case 1: if( x > 600) return true;
            else return false;
            case 2: if( y > 600) return true;
            else return false;
            case 3: if( x < 0) return true;
            else return false;
                 
        }
        return false;
    }
    
    public void tick()
    {
        //up=0, right=1, down=2, left=3
        switch(direction)
        {
            case 0: y -= speed; break;
            case 1: x += speed; break;
            case 2: y += speed; break;
            case 3: x -= speed; break;
        }
        if(bulletTime < 60)
            bulletTime ++;
        else
            bulletReady = true;
        
    }
        
    public void render(Graphics g)
    {
        
        g.drawImage(bl, (int)x, (int)y, 10, 10,  null);
        tick();
    }
}
