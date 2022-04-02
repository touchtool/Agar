package agarssd.client;

import agarssd.model.MoveCommand;
import agarssd.model.Player;
import agarssd.model.World;

public class GreedyStategy implements MoveStrategy{

    public MoveCommand getNextMoveCommand(World world, Player myPlayer) {
        if(world == null) {
            return null;
        }
        MoveCommand command = new MoveCommand();
        Float x = 0f;
        Float y = 0f;
        double minDis = Double.POSITIVE_INFINITY;
        double playerX = (double) myPlayer.positionX;
        double playerY = (double) myPlayer.positionY;
        for (int i = 0; i < world.items.size(); i++) {
            Double itemX = (double) world.items.get(i).positionX;
            Double itemY = (double) world.items.get(i).positionY;
            // calculate distance between 2 point
            Double dis = Math.sqrt(Math.pow(itemX-playerX, 2) + Math.pow(itemY-playerY, 2));
            // find the dot that closest to player
            if (dis < minDis) {
                x = world.items.get(i).positionX;
                y = world.items.get(i).positionY;
                minDis = dis;
            }
        }
        command.toX = x;
        command.toY = y;
        return command;
    }
}
