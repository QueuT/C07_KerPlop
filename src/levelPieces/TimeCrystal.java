package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class TimeCrystal extends GamePiece {

	
	public TimeCrystal(int location) {
        super('T', "TimeCrystal", location);  
    }
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
	     System.out.println("This is TimeCrystal piece: " + getLocation());
		 if (getLocation() == playerLocation) {
	            return InteractionResult.ADVANCE;  // Damages the player when collided
	        }
	        return InteractionResult.NONE;
	        }
}
