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
        GhostArcher archer = new GhostArcher(5);
        gameBoard[8] = archer;

        // Test if GhostArcher interacts with player at distance
        int playerLocation = 6; // Within range of the GhostArcher (attack range is 1)
        assertEquals(InteractionResult.KILL, archer.interact(gameBoard, 10), "GhostArcher should kill the player when within range");

        // Test if GhostArcher does NOT interact with player at far distance
        playerLocation = 8; // Outside range
        assertEquals(InteractionResult.NONE, archer.interact(gameBoard, 18), "GhostArcher should not interact with the player when out of range");
    }
}
