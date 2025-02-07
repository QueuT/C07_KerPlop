package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class PortalPad extends GamePiece implements Drawable {

    public PortalPad(int location) {
        super('w', "Doormat", location);  // 'w' is the symbol for PortalPad
    }

    @Override
    public void draw() {

    }

    public char getSymbol() {
        return 'w';  // PortalPad symbol
    }

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;
	}
}