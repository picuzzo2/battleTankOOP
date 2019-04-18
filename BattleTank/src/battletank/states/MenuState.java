package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuState extends State implements KeyListener
{
    private String [] options = {"Start" , "Quit"};
    private int currentSelection = 0;
    private boolean[] keys;
    private int flagUp,flagDown;
    private boolean up,down;
    
    public MenuState(Game game)
    {
        super(game);
        keys = new boolean[256];
        flagUp = 1;
        flagDown = 1;
    }
    

    @Override
    public void tick() 
    {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        if(game.getKeyManager(10).up && game.getKeyManager(10).flagUp == 1)
        {
            ///System.out.println(currentSelection);
            currentSelection++;
            if(currentSelection >= options.length){
                currentSelection = 0;
            }
            
        }
        else if(game.getKeyManager(10).down)
        {
            currentSelection--;
            if(currentSelection < 0){
                currentSelection = options.length -1 ;
                
            }
        }
    }

    @Override
    public void render(Graphics g) 
    {
        g.drawImage(Assets.bg, 0, 0, null);
        for(int i = 0; i < options.length; i ++){
            if(i == currentSelection){
                g.setColor(Color.GREEN);
            }
            else{
                g.setColor(Color.BLACK);
            }
            g.setFont(new Font("Arail", Font.PLAIN, 72));
            g.drawString(options[i], 600 / 2 - 75, 150+i*150);
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println(flagUp);
        flagUp = 0;
        flagDown = 0;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        flagUp = 1;
        flagDown = 1;
    }
}

