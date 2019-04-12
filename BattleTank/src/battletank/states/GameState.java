package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.player.Player;
import battletank.world.World;
import java.awt.Graphics;

public class GameState extends State {
    
    private Player player1,player2;
    private World world;

    public GameState(Game game)
    {
        
        super(game);
        world = new World("res/world/world1.txt");
        player1 = new Player(world,game, 10, 1, 1, Assets.penguin);
        player2 = new Player(world,game, 10, 18, 2, Assets.penguin );       
    }
    
    @Override
    public void tick() 
    {
        player1.tick();
        player2.tick();
    }

    @Override
    public void render(Graphics g) 
    {
        
        player1.render(g);
        player2.render(g);
        world.render(g);
        
    }
    
}
