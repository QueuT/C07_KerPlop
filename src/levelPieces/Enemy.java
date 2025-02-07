package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Enemy extends GamePiece {

    // Constructor for the Enemy class
    public Enemy(int location) {
        super('E', "Enemy", location);  // 'E' is the symbol for Enemy
    }

    // Interaction logic for the Enemy piece
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == getLocation()) {
            // Player gets hit by the enemy
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;  // No interaction if player is not on the enemy location
    }
}