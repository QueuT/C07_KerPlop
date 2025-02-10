package levelPieces;

import java.util.Random;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class ShadowCrawler extends GamePiece implements Moveable {
    
    private Random rand;

    // Modified constructor to accept a LevelSetup reference
    public ShadowCrawler(int location) {
        super('S', "ShadowCrawler", location);
        this.rand = new Random();
    }

    
    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        int direction = rand.nextInt(2) == 0 ? -1 : 1; // random left or right
        int currentLocation = getLocation(); // Current location of ShadowCrawler
        int newPosition = getLocation() + direction;

        
     // Ensure new position is within bounds
     if (newPosition >= 0 && newPosition < GameEngine.BOARD_SIZE) {

         // Check if the new position is already occupied
         if (gameBoard[newPosition] != null) {
         } else {
             // Clear the old position
             gameBoard[currentLocation] = null;

             // Update the ShadowCrawler's location
             setLocation(newPosition);

             // Place the ShadowCrawler at the new position on the board
             gameBoard[newPosition] = this;
             InteractionResult reaction = interact(gameBoard, playerLocation);
         }
     } else {
         // If the new position is out of bounds, do not move
      }
    }
    
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
    	if (this.getLocation() == playerLocation) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}