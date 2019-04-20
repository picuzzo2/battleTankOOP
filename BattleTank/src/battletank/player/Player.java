package battletank.player;

import battletank.Game;
import battletank.bullets.Bullet;
import battletank.gfx.Assets;
import battletank.world.World;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.easyogg.OggClip;

public class Player 
{
    public static final float DEFAULT_SPEED = 2;
    public static final int PIX_WIDE = 32;
    
    private float speed;
    private float x,y;
    private int size;
    private int player;
    private int direction; // up=0, right=1, down=2, left=3
    private BufferedImage[] avatar;
    
    private World world;
    private Game game;    
    private Bullet bullet;
    private boolean bulletReady=true;
    private int bulletTime = 0;
    private int xBlock1,yBlock1,xBlock2,yBlock2;
    private int life;
    private BufferedImage[] lifeImg;
    private int showLife;
    private OggClip walk;
    private boolean walkReady;
    private int walkTime;
    
    public Player(World world, Game game, int x, int y, int player, BufferedImage[] avatar)
    {
        this.game = game;
        this.world = world;
        
        this.x = x * PIX_WIDE;
        this.y = y * PIX_WIDE;
        this.size = 26;
        this.speed = DEFAULT_SPEED;
        this.player = player;
        this.avatar = avatar;
        lifeImg = new BufferedImage[3];
        this.life = 3;
        
        try {
            walk = new OggClip("sound/walk.ogg"); 

        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        walkReady = true;
        walkTime = 0;
        
        if(player == 1)
            direction = 2;
        else if(player == 2)
            direction = 0;
        
        for(int i=0; i<3; i++)
            lifeImg[i] = Assets.hearts[0];
        showLife = 3*60; //3secs
    }
    
    private void moveUp()
    {
        if(walkReady)
        {
            walk.play();
            walkReady = false;
        }
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
        if(walkReady)
        {
            walk.play();
            walkReady = false;
        }
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
        if(walkReady)
        {
            walk.play();
            walkReady = false;
        }
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
        if(walkReady)
        {
            walk.play();
            walkReady = false;
        }
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
        showLife = 2*60;
        lifeImg[life-1] = Assets.hearts[1];
        
         
        life--;
        
    }

    private void shoot()
    {
        if(bulletReady)
        {
            try {
                bullet = new Bullet(x, y ,direction,world,player);
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            world.bullets.add(bullet);
            //System.out.println(x + " " + tlX() + " " + xBlock1 *PIX_WIDE  );
            bulletReady = false;
        }
    }
    
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
        
        if(!walkReady && walkTime < 60)
        {
            walkTime++;
        }
        else if(!walkReady && walkTime >=60)
        {
            walkTime =0;
            walkReady = true;
        }
        
        //show life
        if(showLife > 0)
            showLife --;
      
    }
    
    public void render(Graphics g)
    {   
        switch(direction)
        {
            case 0:
                g.drawImage(avatar[0], (int)x, (int)y, size, size,  null);
                break;
            case 1:
                g.drawImage(avatar[1], (int)x, (int)y, size, size,  null);
                break;
            case 2:
                g.drawImage(avatar[2], (int)x, (int)y, size, size,  null);
                break;
            case 3:
                g.drawImage(avatar[3], (int)x, (int)y, size, size,  null);
                break;
        }
        for(int i=0; i<showLife; i++)
        {
            for(int j=0; j<3; j++)
                g.drawImage(lifeImg[j],((int)x-15)+(j*20) ,(int)y-20,17,17,null);
        }
        
    }
    
    //gettes
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
    
    
}
