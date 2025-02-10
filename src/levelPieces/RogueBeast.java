package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class RogueBeast extends GamePiece implements Moveable {

    public RogueBeast(int location) {
        super('R', "RougeBeast", location);  // Call the GamePiece constructor
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        // Check if the RogueBeast's location matches the player's location
        if (this.getLocation() == playerLocation) {
            return InteractionResult.HIT;  // Player gets hit by the RogueBeast
        }
        return InteractionResult.NONE;  // No interaction if locations don't match
    }

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        // Example of random movement: move left or right randomly
        int randomMove = (int) (Math.random() * 2); // 0 or 1
        int newLocation = (randomMove == 0) ? this.getLocation() - 1 : this.getLocation() + 1;
        if (newLocation >= 0 && newLocation < GameEngine.BOARD_SIZE) {

            setLocation(newLocation);  // Update location if valid

        }
    }
}