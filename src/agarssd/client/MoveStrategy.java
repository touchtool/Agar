package agarssd.client;

import agarssd.model.MoveCommand;
import agarssd.model.Player;
import agarssd.model.World;

public interface MoveStrategy {
    MoveCommand getNextMoveCommand(World world, Player myPlayer);
}
