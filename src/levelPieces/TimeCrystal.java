package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class TimeCrystal extends GamePiece {

	
	public TimeCrystal(int location) {
        super('T', "TimeCrystal", location);  // 'M' is the symbol for MysticGuardian
    }
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
	        
		 if (getLocation() == playerLocation) {
	            return InteractionResult.ADVANCE;  // Damages the player when collided
	        }
	        return InteractionResult.NONE;
	        }
}
