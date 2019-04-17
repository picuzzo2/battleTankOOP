package battletank.states;

import battletank.Game;
import battletank.world.World;
import java.awt.Graphics;

public class GameState extends State {
    

    private World world;

    public GameState(Game game)
    {
        
        super(game);
        world = new World("res/world/world1.txt",game);
          
    }
    
    
    
    @Override
    public void tick() 
    {
        world.tick();
    }

    @Override
    public void render(Graphics g) 
    {
        world.render(g);
        
    }
    
    
    
}
