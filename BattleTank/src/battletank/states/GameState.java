package battletank.states;

import battletank.Game;
import battletank.gfx.Assets;
import battletank.player.Player;
import java.awt.Graphics;

public class GameState extends State {
    
    private Player player1,player2;

    public GameState(Game game)
    {
        super(game);
        player1 = new Player(game, 0, 0, 1, Assets.penguin);
        player2 = new Player(game, 800, 800, 2, Assets.pig);
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
        
    }
    
}
