package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

public class RogueBeast extends GamePiece implements Moveable {
    private Random random;
    
	public RogueBeast(int location) {
        super('R', "RogueBeast", location);
        this.random = new Random();
	}

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        int randomMove = random.nextInt(2);
        int newLocation = (randomMove == 0) ? getLocation() - 1 : getLocation() + 1;

        if (newLocation >= 0 && newLocation < GameEngine.BOARD_SIZE) {
            setLocation(newLocation);  // Update location
        }
    }

    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
        	System.out.println("Player hit by RogueBeast within range!");
            return InteractionResult.HIT;  // Damages the player when collided
        }
        return InteractionResult.NONE;
    }
}