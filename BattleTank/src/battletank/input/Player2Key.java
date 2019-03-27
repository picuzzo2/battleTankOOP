package battletank.input;

import java.awt.event.KeyEvent;

public class Player2Key extends KeyManager
        
{
    @Override
    public void tick() 
    {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        shoot = keys[KeyEvent.VK_SPACE];
    }
    
}
