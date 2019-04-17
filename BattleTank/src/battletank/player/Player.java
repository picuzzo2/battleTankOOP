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
    private Bullet bullet;
    private boolean bulletReady=true;
    private int bulletTime = 0;
    private int xBlock1,yBlock1,xBlock2,yBlock2;
    private int life;
   
    
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
        this.life = 3;
        
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
        else if(!world.b[xBlock1][yBlock1].moveAble 
           && y <= ((yBlock1) *PIX_WIDE) + PIX_WIDE )
        {
            y = (yBlock1 *PIX_WIDE) +PIX_WIDE ;
        }  
        else if(!world.b[xBlock2][yBlock2].moveAble 
                && y <= ((yBlock2) *PIX_WIDE) + PIX_WIDE )
        {
            y = (yBlock2 *PIX_WIDE) +PIX_WIDE ;
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
        else if(!world.b[xBlock1][yBlock1].moveAble
                && y + size >= (yBlock1 *PIX_WIDE) )
        {
            y = (yBlock1 *PIX_WIDE) -size -1;
        }   
        else if(!world.b[xBlock2][yBlock2].moveAble
                && y + size >= (yBlock2 *PIX_WIDE) )
        {
            y = (yBlock2 *PIX_WIDE) -size -1;
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
        else if(!world.b[xBlock1][yBlock1].moveAble
                && x  <= (xBlock1 *PIX_WIDE)+ PIX_WIDE )
        {
            x = (xBlock1 *PIX_WIDE) +PIX_WIDE+1;
        }
        else if(!world.b[xBlock2][yBlock2].moveAble
                && x  <= (xBlock2 *PIX_WIDE)+ PIX_WIDE )
        {
            x = (xBlock2 *PIX_WIDE) +PIX_WIDE+1;
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
        else if(!world.b[xBlock1][yBlock1].moveAble
                &&x + size >= (xBlock1 *PIX_WIDE) )
        {
            x = (xBlock1 *PIX_WIDE) -size -1;
        } 
        else if(!world.b[xBlock2][yBlock2].moveAble
                &&x + size >= (xBlock2 *PIX_WIDE) )
        {
            x = (xBlock2 *PIX_WIDE) -size -1;
        }  
        
    }
    
    private void set_checkBlocks()
    {
        switch(direction)
        {
            case 0:
                xBlock1 = (tlX()/PIX_WIDE) ;
                yBlock1 = ((tlY()-1)/PIX_WIDE) ;
                xBlock2 = (trX()/PIX_WIDE) ;
                yBlock2 = ((trY()-1)/PIX_WIDE) ;
                break;
            case 1:
                xBlock1 = ((brX()+1)/PIX_WIDE) ;
                yBlock1 = (brY()/PIX_WIDE) ;
                xBlock2 = ((trX()+1)/PIX_WIDE) ;
                yBlock2 = (trY()/PIX_WIDE) ;
                break;
            case 2:
                xBlock1 = (blX()/PIX_WIDE) ;
                yBlock1 = ((blY()+1)/PIX_WIDE) ;
                xBlock2 = (brX()/PIX_WIDE) ;
                yBlock2 = ((brY()+1)/PIX_WIDE) ;
                break;
            case 3:
                xBlock1 = ((tlX()-2)/PIX_WIDE) ;
                yBlock1 = (tlY()/PIX_WIDE) ;
                xBlock2 = ((blX()-2)/PIX_WIDE) ;
                yBlock2 = (blY()/PIX_WIDE) ;
                break;
                
        }
    }

    public void hit()
    {
        life --;
        System.out.println(player + " " +life);
    }

    private void shoot()
    {
        if(bulletReady)
        {
            bullet = new Bullet(x, y ,direction,world,player);
            World.bullets.add(bullet);
            //System.out.println(x + " " + tlX() + " " + xBlock1 *PIX_WIDE  );
            bulletReady = false;
        }
    }
    
    
    private int tlX() { return (int)x ; }
    private int tlY() { return (int)y ; }
    private int trX() { return (int)x + size ; }
    private int trY() { return (int)y ; }
    private int blX() { return (int)x ; }
    private int blY() { return (int)y + size ; }
    private int brX() { return (int)x + size ; }
    private int brY() { return (int)y + size ; }
    public int getX() { return (int)x ; }
    public int getY() { return (int)y ; }
    public int getID() { return player; }
    public int getLife() { return life; }
    
    public void tick()
    {       
        if(game.getKeyManager(player).up)
            moveUp();
        else if(game.getKeyManager(player).down)
            moveDown();
        else if(game.getKeyManager(player).left)
            moveLeft();
        else if(game.getKeyManager(player).right)
            moveRight();
        if(game.getKeyManager(player).shoot)
                shoot();
        
        if(!bulletReady && bulletTime < 20)
        {
            bulletTime ++;
            //System.out.print(bulletTime + " ");
        }
        else if (!bulletReady && bulletTime >= 20)
        {
            bulletTime = 0;
            bulletReady = true;
            //System.out.println("READY");
        }
    }
    
    public void render(Graphics g)
    {   
        g.drawImage(avatar, (int)x, (int)y, size, size,  null);
        
    }
    
    
}
