package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class MysticGuardian extends GamePiece {

    public MysticGuardian(int location) {
        super('M', "MysticGuardian", location);  // 'M' is the symbol for MysticGuardian
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (this.getLocation() == playerLocation) {
            // grant bonus
            return InteractionResult.GET_POINT;
        }
        return InteractionResult.NONE;
    }
}
