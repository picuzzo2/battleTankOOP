package battletank.player;

import battletank.Game;
import battletank.bullets.Bullet;
import battletank.world.World;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player 
{
    public static final float DEFAULT_SPEED = 2;
    public static final int PIX_WIDE = 32;

    private float speed;
    private float x,y;
    private int size;
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
        this.size = 26;
        this.game = game;
        this.world = world;
        speed = 2;
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
        set_checkBlocks();
        
        if(   world.b[xBlock1][yBlock1].moveAble //check collision
           && world.b[xBlock2][yBlock2].moveAble)
        {
            y -= speed;
        }
        else if( collisionWithBlock())
        {
            for(int i=0; i<speed; i++)
            {
                if( collisionWithBlock())
                    y -= 1;
            }
        }
    }
    
    private void moveDown()
    {
        direction = 2;
        //draw tl and tr grid
        set_checkBlocks();
        
        if(   world.b[xBlock1][yBlock1].moveAble //check collision
           && world.b[xBlock2][yBlock2].moveAble)
        {
            y += speed;
        }
        else if( collisionWithBlock())
        {
            for(int i=0; i<speed; i++)
            {
                if( collisionWithBlock())
                    y += 1;
            }
        }
    }
    
    private void moveLeft()
    {
        direction = 3;
        //draw tl and tr grid
        set_checkBlocks();
        
        if(    world.b[xBlock1][yBlock1].moveAble 
            && world.b[xBlock2][yBlock2].moveAble)
        {
            x -= speed;
        }
        else if( collisionWithBlock())
        {
            for(int i=0; i<speed; i++)
            {
                if( collisionWithBlock())
                    x -= 1;
            }
        }
    }
    
    private void moveRight()
    {
        direction = 1;
        //draw tl and tr grid
        set_checkBlocks();
        
        if(   world.b[xBlock1][yBlock1].moveAble //check collision
           && world.b[xBlock2][yBlock2].moveAble)
        {   
            x += speed;   
        }
        else if( collisionWithBlock())
        {
            for(int i=0; i<speed; i++)
            {
                if( collisionWithBlock())
                    x += 1;
                
            }
        }
        
    }
    
    private void set_checkBlocks()
    {
        switch(direction)
        {
            case 0:
                xBlock1 = (tlX()/PIX_WIDE) ;
                yBlock1 = (tlY()/PIX_WIDE) -1;
                xBlock2 = (trX()/PIX_WIDE) ;
                yBlock2 = (trY()/PIX_WIDE) -1;
                break;
            case 1:
                xBlock1 = (brX()/PIX_WIDE) +1;
                yBlock1 = (brY()/PIX_WIDE) ;
                xBlock2 = (trX()/PIX_WIDE) +1;
                yBlock2 = (trY()/PIX_WIDE) ;
                break;
            case 2:
                xBlock1 = (blX()/PIX_WIDE) ;
                yBlock1 = (blY()/PIX_WIDE) +1;
                xBlock2 = (brX()/PIX_WIDE) ;
                yBlock2 = (brY()/PIX_WIDE) +1;
                break;
            case 3:
                xBlock1 = (tlX()/PIX_WIDE) -1;
                yBlock1 = (tlY()/PIX_WIDE) ;
                xBlock2 = (blX()/PIX_WIDE) -1;
                yBlock2 = (blY()/PIX_WIDE) ;
                break;
                
        }
    }
    
    private boolean collisionWithBlock()
    {
        switch(direction)
            //up=0 right=1 down=2 left=3
        {
            case 0:
                return tlY() > (yBlock1+1) * PIX_WIDE 
                    && trY() > (yBlock2+1) * PIX_WIDE;
            case 1:
                return trX() < ((xBlock1) * PIX_WIDE)-1 
                    && brX() < ((xBlock2) * PIX_WIDE)-1;
            case 2:
                return blY() < ((yBlock1) * PIX_WIDE)-1
                    && brY() < ((yBlock2) * PIX_WIDE)-1;
            case 3:
                return tlX() > (xBlock1+1) * PIX_WIDE 
                    && blX() > (xBlock2+1) * PIX_WIDE;
        }
        return false;
    }
    

    private void shoot()
    {
        System.out.println(tlX() + " " + blX() + " " + (xBlock1+1)*PIX_WIDE + " " + (xBlock2+1)*PIX_WIDE);
        System.out.println(world.b[xBlock1][yBlock1].moveAble //check collision
           && world.b[xBlock2][yBlock2].moveAble);
        System.out.println(collisionWithBlock());

        bullet = new Bullet(x + PIX_WIDE / 2, y + PIX_WIDE/2 ,direction);
    }
    
    public float getXpos()
    {
        return x;
    }
    public float getYpos()
    {
        return y;
    }
    
    private int tlX() { return (int)x; }
    private int tlY() { return (int)y; }
    private int trX() { return (int)x + size; }
    private int trY() { return (int)y; }
    private int blX() { return (int)x; }
    private int blY() { return (int)y + size; }
    private int brX() { return (int)x + size; }
    private int brY() { return (int)y + size; }
    
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
        g.drawImage(avatar, (int)x, (int)y, size, size,  null);
        
    }
    
    
}
