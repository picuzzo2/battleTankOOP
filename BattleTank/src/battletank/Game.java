package battletank;

import battletank.Display.Display;
import battletank.gfx.Assets;
import battletank.input.KeyManager;
import battletank.states.GameState;
import battletank.states.MenuState;
import battletank.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable
{
    private Display display;
    private int width, height;
    private String title;
  
    private Thread thread;
    private boolean running = false;
    
    private BufferStrategy bs;
    private Graphics g;
    
   //States
    private State gameState;
    private State menuState;
    
    private KeyManager p1Control, p2Control;
    
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;              
        p1Control = new KeyManager(1);
        p2Control = new KeyManager(2);
    }
    
    private void init()
    {        
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(p1Control);
        display.getFrame().addKeyListener(p2Control);
        Assets.init();
        
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
    }
    
  
    private void tick()
    {
        p2Control.tick();
        p1Control.tick();
        if(State.getState() != null)
            State.getState().tick();
    }
    
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Start
        
       if(State.getState() != null)
            
            State.getState().render(g);
        
        
        //End draw
        bs.show();
        g.dispose();
    }
    
    public void run()
    {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1)
            {
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000)
            {
                ticks =0;
                timer =0;
            }
        }
        
        stop();
    }
    
    public synchronized void start()
    {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start(); //call run method
    }
    
    public synchronized void stop()
    {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public KeyManager getKeyManager(int player) 
    { 
        if(player == 1 )
            return p1Control;
        else if(player == 2 )
            return p2Control;
        return null;
    }
}
