package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class ShadowCrawler extends GamePiece implements Moveable {
	
	private Random rand;
	
	//Constructor
	public ShadowCrawler(int location) {
		super('S', "ShadowCrawler", location);
		this.rand = new Random();
	}

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        int direction = rand.nextInt(2) == 0 ? -1 : 1; // Move left (-1) or right (+1)
        int newPosition = getLocation() + direction;

        // Ensure it stays within bounds
        if (newPosition >= 0 && newPosition < GameEngine.BOARD_SIZE) {
            setLocation(newPosition);
        }
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
            return InteractionResult.HIT;  // Hits player if they in the same space
        }
        return InteractionResult.NONE;
    }
}
