package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class GhostArcher extends GamePiece {
    private static final int ATTACK_RANGE = 1; // Define the range for the attack

    public GhostArcher(int location) {
        super('G', "GhostArcher", location);  // 'M' is the symbol for MysticGuardian
    }
    
    //@Override
    //public void draw() {
        // Print 'G' for GhostArcher
    //    System.out.print("G");
    //}
    
    @Override
    public InteractionResult interact(Drawable[] board, int playerLocaction) {
        // Check if the player is within the attack range of the GhostArcher
        if (Math.abs(playerLocaction - this.getLocation()) <= ATTACK_RANGE) {
            return InteractionResult.KILL; // Player takes damage if within range
        }

        return InteractionResult.NONE; // No interaction if out of range
    }
}
