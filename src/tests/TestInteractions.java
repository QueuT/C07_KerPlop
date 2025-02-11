package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import gameEngine.Drawable;
import levelPieces.GhostArcher;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class TestInteractions {

    // Test GhostArcher interaction with player
    @Test
    public void testGhostArcherInteraction() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        GhostArcher archer = new GhostArcher(8);
        gameBoard[8] = archer;

        // Test if GhostArcher interacts with player at distance
        assertEquals(InteractionResult.KILL, archer.interact(gameBoard, 10), "GhostArcher should hit the player at position 10");

        // Test if GhostArcher does NOT interact with player at far distance
        assertEquals(InteractionResult.NONE, archer.interact(gameBoard, 18), "GhostArcher should not hit the player at position 18");
    }
}
