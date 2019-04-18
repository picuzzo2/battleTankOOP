package battletank.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class KeyManager implements KeyListener
{
    protected boolean[] keys;
    public int flagUp,flagDown;
    public boolean up, down, left, right, shoot;
    
    
    public KeyManager()
    {
        
        keys = new boolean[256];
        flagUp = 1;
        flagDown =1 ;
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
        flagUp = 0;
        flagDown =0 ;
        System.out.println(flagUp);
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) 
    {
        keys[arg0.getKeyCode()] = false;
        flagUp = 1;
        flagDown =1 ;
    }
    
}
