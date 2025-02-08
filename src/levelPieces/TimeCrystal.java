package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class TimeCrystal extends GamePiece {

	
	public TimeCrystal(int location) {
        super('T', "TimeCrystal", location);  
    }
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		 if (getLocation() == playerLocation) {
	            return InteractionResult.ADVANCE;  // Granting the player for next level when collided
	        }
	        return InteractionResult.NONE;
	        }
}
