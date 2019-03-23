package battletank.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class KeyManager implements KeyListener
{
    protected boolean[] keys;
    public boolean up, down, left, right;
    
    
    public KeyManager()
    {
        
        keys = new boolean[256];
    }
    
    public abstract void tick();
    
    
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
