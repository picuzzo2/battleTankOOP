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
    public static final float DEFAULT_SPEED = 3;
    public static final int PIX_WIDE = 32;

    private float x,y,speed;
    private int width , height;
    private int player;
    private int direction; // up=0, right=1, down=2, left=3
    private BufferedImage avatar;
    
    
    private World world;
    private Game game;    
    private Bullet bullet = null;
    private boolean bulletAppear = false;
    public int trX,trY
            ,tlX,tlY
            ,brX,brY
            ,blX,blY;
    private int tempx1,tempy1,tempx2,tempy2;
   
    
    public Player(World world,Game game, float x, float y, int player, BufferedImage avatar)
    {
        this.x = x * PIX_WIDE;
        this.y = y * PIX_WIDE;
        this.width = 25;
        this.height = 25;
        this.game = game;
        this.world = world;
        speed = DEFAULT_SPEED;
        this.player = player;
        this.avatar = avatar;

        //Hit boxes
        tlX = (int)x; tlY = (int)y;
        trX = (int)x+width; trY = (int)y;
        blX = (int)x; blY = (int)y+height;
        brX = (int)x+width; brY = (int)y+height;
        
        
        if(player == 1)
            direction = 2;
        else if(player == 2)
            direction = 0;
        
    }
    
    private void moveUp()
    {
        direction = 0;
        //draw tl and tr grid
        tempx1 = (tlX/PIX_WIDE) ;
        tempy1 = (tlY/PIX_WIDE) -1;
        tempx2 = (trX/PIX_WIDE) ;
        tempy2 = (trY/PIX_WIDE) -1;
 
        if(y > 0 && world.b[tempx1][tempy1].moveAble 
                && world.b[tempx2][tempy2].moveAble )
            y -= speed;
    }
    
    private void moveDown()
    {
        direction = 2;
        //draw tl and tr grid
        tempx1 = (blX/PIX_WIDE) ;
        tempy1 = (blY/PIX_WIDE) +1;
        tempx2 = (brX/PIX_WIDE) ;
        tempy2 = (brY/PIX_WIDE) +1;
        if(y < 20*PIX_WIDE-width && world.b[tempx1][tempy1].moveAble 
               && world.b[tempx2][tempy2].moveAble)
        y += speed;
    }
    
    private void moveLeft()
    {
        direction = 3;
        //draw tl and tr grid
        tempx1 = (tlX/PIX_WIDE) -1;
        tempy1 = (tlY/PIX_WIDE) ;
        tempx2 = (blX/PIX_WIDE) -1;
        tempy2 = (blY/PIX_WIDE) ;
        if(x > 0 && world.b[tempx1][tempy1].moveAble 
                && world.b[tempx2][tempy2].moveAble )
        x -= speed;
    }
    
    private void moveRight()
    {
        direction = 1;
        //draw tl and tr grid
        tempx1 = (brX/PIX_WIDE) +1;
        tempy1 = (brY/PIX_WIDE) ;
        tempx2 = (trX/PIX_WIDE) +1;
        tempy2 = (trY/PIX_WIDE) ;
        if(x < 20*PIX_WIDE-height && world.b[tempx1][tempy1].moveAble 
                && world.b[tempx2][tempy2].moveAble)
            x += speed;
  
    }
    

    private void shoot()
    {
        bullet = new Bullet(x + PIX_WIDE / 2, y + PIX_WIDE/2 ,direction);
    }
    
    public void tick()
    {
        
        tlX = (int)x; tlY = (int)y;
        trX = (int)x+width; trY = (int)y;
        blX = (int)x; blY = (int)y+height;
        brX = (int)x+width; brY = (int)y+height;
        
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
            g.fillRect(tempx1*PIX_WIDE, tempy1*PIX_WIDE, 10, 10);
            g.fillRect(tempx2*PIX_WIDE, tempy2*PIX_WIDE, 10, 10);
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
