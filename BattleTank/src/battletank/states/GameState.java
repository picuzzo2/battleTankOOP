package battletank.states;

import battletank.Game;
import battletank.blocks.Blocks;
import battletank.blocks.BrickBlock;
import battletank.gfx.Assets;
import battletank.player.Player;
import java.awt.Graphics;

public class GameState extends State {
    
    private Player player1,player2;
    private Blocks testB;

    public GameState(Game game)
    {
        super(game);
        player1 = new Player(game, 0, 0, 1, Assets.penguin);
        player2 = new Player(game, 250, 250, 2, Assets.pig);
        testB = new BrickBlock(Assets.hippo, 1);
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
        testB.render(g);
        player1.render(g);
        player2.render(g);
        
    }
    
}
