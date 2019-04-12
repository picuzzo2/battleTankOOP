
package battletank.bullets;

import battletank.gfx.Assets;
import battletank.player.Player;
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
    private Player enemy;
    
    
    public Bullet(float x, float y, int direction)
    {      
        bulletTime = 0;
        speed = 10;
        this.x = x-5;
        this.y = y-5;
        bl = Assets.pig;
        this.direction = direction;
        bulletReady = false;

    }
    
    public boolean isReady()
    {
        return bulletReady;
    }
    
    public void tick()
    {
        //up=0, right=1, down=2, left=3
        switch(direction)
        {
            case 0: 
                for(int i=0; i<speed; i++)
                    y -= 1; 
                break;
            case 1: 
                for(int i=0; i<speed; i++)
                    x += 1; 
                break;
            case 2: 
                for(int i=0; i<speed; i++)
                    y += 1; 
                break;
            case 3: 
                for(int i=0; i<speed; i++)
                    x -= 1; 
                break;
        }
        if(bulletTime < 60)
            bulletTime ++;
        else
            bulletReady = true;
        
    }
    
    public void hitPlayer()
    {
        //up=0, right=1, down=2, left=3
        switch(direction)
        {
            
        }
    }
        
    public void render(Graphics g)
    {
        g.drawImage(bl, (int)x , (int)y , 5, 20,  null);
        tick();
    }
}
