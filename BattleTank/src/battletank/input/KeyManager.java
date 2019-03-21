package battletank.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    private boolean[] keys;
    public boolean up, down, left, right;
    private int player;
    
    public KeyManager(int player)
    {
        this.player = player;
        keys = new boolean[256];
    }
    
    public void tick()
    {
        if(player == 1)
        {
            up = keys[KeyEvent.VK_UP];
            down = keys[KeyEvent.VK_DOWN];
            left = keys[KeyEvent.VK_LEFT];
            right = keys[KeyEvent.VK_RIGHT];
        }
        else if(player == 2)
        {
            up = keys[KeyEvent.VK_W];
            down = keys[KeyEvent.VK_S];
            left = keys[KeyEvent.VK_A];
            right = keys[KeyEvent.VK_D];
        }
    }
    
    @Override
    public void keyTyped(KeyEvent arg0) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) 
    {
        keys[arg0.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) 
    {
        keys[arg0.getKeyCode()] = false;
    }
    
}
