package battletank.player;

import battletank.Game;
import battletank.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player 
{
    public static final float DEFAULT_SPEED = 3;
    public static final int DEFAULT_HEIGHT = 30,
                            DEFAULT_WIDTH = 30;
    private Game game;
    private float x,y,speed;
    private int width, height;
    private int player;
    private BufferedImage avatar;
   
    
    public Player(Game game, float x, float y, int player, BufferedImage avatar)
    {
        this.x = x;
        this.y = y;
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        this.game = game;
        speed = DEFAULT_SPEED;
        this.player = player;
        this.avatar = avatar;
        
    }
    
    public void tick()
    {
        if(game.getKeyManager(player).up)
            y -= speed;
        if(game.getKeyManager(player).down)
            y += speed;
        if(game.getKeyManager(player).left)
            x -= speed;
        if(game.getKeyManager(player).right)
            x += speed;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(avatar, (int)x, (int)y, width, height,  null);
    }
    
    
}