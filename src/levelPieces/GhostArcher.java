package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class GhostArcher extends GamePiece {

    public GhostArcher(int location) {
        super('G', "GhostArcher", location);  // 'G' is the symbol for GhostArcher
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (this.getLocation() == playerLocation) {
            return InteractionResult.KILL; // kill the player
        }
        return InteractionResult.NONE;
    }
}
