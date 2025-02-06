package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Prize extends GamePiece {

    // Constructor for the Prize class
    public Prize(int location) {
        super('X', "Prize", location);  // 'x' is the symbol for Prize
    }

    // Interaction logic for the Prize piece
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == getLocation()) {
            // Player collects the prize
            return InteractionResult.GET_POINT;
        }
        return InteractionResult.NONE;  // No interaction if player is not on the prize location
    }
}
