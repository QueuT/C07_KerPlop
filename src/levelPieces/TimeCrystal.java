package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class TimeCrystal extends GamePiece {

	
	public TimeCrystal(int location) {
        super('T', "TimeCrystal", location);  
    }
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
<<<<<<< HEAD
	     System.out.println("This is TimeCrystal piece: " + getLocation());
		 if (this.getLocation() == playerLocation) {
	            return InteractionResult.ADVANCE;  
=======
		 if (getLocation() == playerLocation) {
	            return InteractionResult.ADVANCE;  // Granting the player for next level when collided
>>>>>>> 42471f357fb621d11c6a44e1e06d5ca5221d9d2f
	        }
	        return InteractionResult.NONE;
	        }
}
