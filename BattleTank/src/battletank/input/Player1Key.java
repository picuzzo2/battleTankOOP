
package battletank.input;

import java.awt.event.KeyEvent;

public class Player1Key extends KeyManager {

    @Override
    public void tick() 
    {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        shoot = keys[KeyEvent.VK_CONTROL];
    }
}
