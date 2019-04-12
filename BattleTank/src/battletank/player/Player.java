package battletank.player;

import battletank.Game;
import battletank.blocks.Blocks;
import battletank.bullets.Bullet;
import battletank.gfx.Assets;
import battletank.world.World;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player 
{
    public static final float DEFAULT_SPEED = 2;
    public static final int PIX_WIDE = 32;

    private float speed;
    private int x,y;
    private int width , height;
    private int player;
    private int direction; // up=0, right=1, down=2, left=3
    private BufferedImage avatar;
    
    
    private World world;
    private Game game;    
    private Bullet bullet = null;
    private boolean bulletAppear = false;
    private int xBlock1,yBlock1,xBlock2,yBlock2;
   
    
    public Player(World world,Game game, int x, int y, int player, BufferedImage avatar)
    {
        this.x = x * PIX_WIDE;
        this.y = y * PIX_WIDE;
        this.width = 26;
        this.height = 26;
        this.game = game;
        this.world = world;
        speed = DEFAULT_SPEED;
        this.player = player;
        this.avatar = avatar;
        
        if(player == 1)
            direction = 2;
        else if(player == 2)
            direction = 0;
        
    }
    
    private void moveUp()
    {
        direction = 0;
        //draw tl and tr grid
        xBlock1 = (tlX()/PIX_WIDE) ;
        yBlock1 = (tlY()/PIX_WIDE) -1;
        xBlock2 = (trX()/PIX_WIDE) ;
        yBlock2 = (trY()/PIX_WIDE) -1;
 
        if(y > 0 
                && xBlock1 >= 0 && yBlock1 >= 0 //check out of screen
                && xBlock2 < 20 && yBlock2 < 20)
        {
            
            if(   world.b[xBlock1][yBlock1].moveAble //check collision
               && world.b[xBlock2][yBlock2].moveAble)
            {
                y -= speed;
            }
            
            else if( collisionWithBlock())
            {
                y -= speed;
            }
        }
    }
    
    private void moveDown()
    {
        direction = 2;
        //draw tl and tr grid
        xBlock1 = (blX()/PIX_WIDE) ;
        yBlock1 = (blY()/PIX_WIDE) +1;
        xBlock2 = (brX()/PIX_WIDE) ;
        yBlock2 = (brY()/PIX_WIDE) +1;
        if(y < 20*PIX_WIDE-width 
                && xBlock1 >=0 && yBlock1 >=0 //check out of screen
                && xBlock2 < 20 && yBlock2 < 20)
        {
            if(   world.b[xBlock1][yBlock1].moveAble //check collision
               && world.b[xBlock2][yBlock2].moveAble)
            {
                y += speed;
            }
            else if( collisionWithBlock())
            {
               
                y += speed;
                
            }
        }
    }
    
    private void moveLeft()
    {
        direction = 3;
        //draw tl and tr grid
        xBlock1 = (tlX()/PIX_WIDE) -1;
        yBlock1 = (tlY()/PIX_WIDE) ;
        xBlock2 = (blX()/PIX_WIDE) -1;
        yBlock2 = (blY()/PIX_WIDE) ;
        if(x > 0 
                && xBlock1 >= 0 && yBlock1 >= 0
                && xBlock2 >= 0 && yBlock2 >= 0 )
        {
            
            if(    world.b[xBlock1][yBlock1].moveAble 
                && world.b[xBlock2][yBlock2].moveAble)
            {
                x -= speed;
            }
            else if( collisionWithBlock())
            {
                x -= speed;
            }
        }     
    }
    
    private void moveRight()
    {
        direction = 1;
        //draw tl and tr grid
        xBlock1 = (brX()/PIX_WIDE) +1;
        yBlock1 = (brY()/PIX_WIDE) ;
        xBlock2 = (trX()/PIX_WIDE) +1;
        yBlock2 = (trY()/PIX_WIDE) ;
        if(x < 20*PIX_WIDE-height 
                && xBlock1 < 20 && yBlock1 < 20 //check out of screen
                && xBlock2 < 20 && yBlock2 < 20)
        {
            if(   world.b[xBlock1][yBlock1].moveAble //check collision
               && world.b[xBlock2][yBlock2].moveAble)
            {   
                x += speed;   
            }
            else if( collisionWithBlock())
            {
                x += speed;
            }
            
        }
  
    }
    
    private boolean collisionWithBlock()
    {
        switch(direction)
        {
            case 0:
                return tlY() > (yBlock1+1) * PIX_WIDE 
                    && trY()  > (yBlock2+1) * PIX_WIDE;
            case 1:
                return trX()+2  < (xBlock1) * PIX_WIDE 
                    && brX()+2  < (xBlock2) * PIX_WIDE;
            case 2:
                return blY()+2 < (yBlock1) * PIX_WIDE 
                    && brY()+2 < (yBlock2) * PIX_WIDE;
            case 3:
                return tlX() > (xBlock1+1) * PIX_WIDE 
                    && blX() > (xBlock2+1) * PIX_WIDE;
        }
        return false;
    }
    

    private void shoot()
    {
        System.out.println(blY() + " " + brY() + " " + yBlock1*PIX_WIDE);
        bullet = new Bullet(x + PIX_WIDE / 2, y + PIX_WIDE/2 ,direction);
    }
    
    private int tlX() { return (int)x; }
    private int tlY() { return (int)y; }
    private int trX() { return (int)x + width; }
    private int trY() { return (int)y; }
    private int blX() { return (int)x; }
    private int blY() { return (int)y + height; }
    private int brX() { return (int)x + width; }
    private int brY() { return (int)y + height; }
    
    public void tick()
    {       
        if(game.getKeyManager(player).up)
            moveUp();
        if(game.getKeyManager(player).down)
            moveDown();
        if(game.getKeyManager(player).left)
            moveLeft();
        if(game.getKeyManager(player).right)
            moveRight();
        if(game.getKeyManager(player).shoot)
            if(!bulletAppear)
                shoot();
        
    }
    
    public void render(Graphics g)
    {
        
        try 
        {
            g.fillRect(xBlock1*PIX_WIDE, yBlock1*PIX_WIDE, 10, 10);
            g.fillRect(xBlock2*PIX_WIDE, yBlock2*PIX_WIDE, 10, 10);
            if(bulletAppear)
            {
                bullet.render(g);
                bulletAppear = !bullet.isReady();
            }
            else
                bulletAppear = !bullet.isReady();
       
            
        } catch (Exception e) { }
        g.drawImage(avatar, (int)x, (int)y, width, height,  null);
        
    }
    
    
}
