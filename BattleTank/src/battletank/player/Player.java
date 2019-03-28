package battletank.player;

import battletank.Game;
import battletank.bullets.Bullet;
import battletank.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player 
{
    public static final float DEFAULT_SPEED = 3;
    public static final float WIDTH = 32;

    private float x,y,speed;
    private int width , height;
    private int player;
    private int direction; // up=0, right=1, down=2, left=3
    private BufferedImage avatar;
    
    private Game game;    
    private Bullet bullet = null;
    private boolean bulletAppear = false;
   
    
    public Player(Game game, float x, float y, int player, BufferedImage avatar)
    {
        this.x = x;
        this.y = y;
        this.width = (int)WIDTH;
        this.height = (int)WIDTH;
        this.game = game;
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
        if(y > 0)
        y -= speed;
    }
    
    private void moveDown()
    {
        direction = 2;
        if(y < 600-width)
        y += speed;
    }
    
    private void moveLeft()
    {
        direction = 3;
        if(x > 0 )
        x -= speed;
    }
    
    private void moveRight()
    {
        direction = 1;
        if(x < 600-height)
        x += speed;
    }
    

    private void shoot()
    {
        bullet = new Bullet(x + WIDTH / 2, y + WIDTH/2 ,direction);
    }
    
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
