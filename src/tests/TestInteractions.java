package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import gameEngine.Drawable;
import levelPieces.GhostArcher;
import levelPieces.MysticGuardian;
import levelPieces.PortalPad;
import levelPieces.RogueBeast;
import levelPieces.TimeCrystal;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class TestInteractions {

    // Test GhostArcher interaction with player
    @Test
    public void testGhostArcherInteraction() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        GhostArcher archer = new GhostArcher(5);
        gameBoard[5] = archer;

        // Test if GhostArcher interacts with player at distance
        InteractionResult result = archer.interact(gameBoard, 4);
        assertEquals(InteractionResult.KILL, result, "GhostArcher should kill the player when within range");

        // Test if GhostArcher does NOT interact with player at far distance
        result = archer.interact(gameBoard, 7);
        assertEquals(InteractionResult.NONE, result, "GhostArcher should not interact with the player when out of range");
    }
    

    @Test
    public void testMysticGuardianInteraction() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        MysticGuardian guardian = new MysticGuardian(5);
        gameBoard[5] = guardian;

        // Test interaction when player is at the same location
        InteractionResult result = guardian.interact(gameBoard, 5);
        assertEquals(InteractionResult.GET_POINT, result, "MysticGuardian should grant a point when player is at the same location");

        // Test no interaction when player is not at the same location
        result = guardian.interact(gameBoard, 7);
        assertEquals(InteractionResult.NONE, result, "MysticGuardian should not interact with player at a different location");
    }

     @Test
    public void testRogueBeastInteraction() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        RogueBeast beast = new RogueBeast(5);
        gameBoard[5] = beast;

        // Test interaction with player at the same location
        InteractionResult result = beast.interact(gameBoard, 5);
        assertEquals(InteractionResult.HIT, result, "RogueBeast should hit player at the same location");

        // Test no interaction when player is not at the same location
        result = beast.interact(gameBoard, 7);
        assertEquals(InteractionResult.NONE, result, "RogueBeast should not interact with player at a different location");
    }

    @Test
    public void testTimeCrystalInteraction() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        TimeCrystal crystal = new TimeCrystal(5);
        gameBoard[5] = crystal;

        // Test interaction when player is at the same location
        InteractionResult result = crystal.interact(gameBoard, 5);
        assertEquals(InteractionResult.ADVANCE, result, "TimeCrystal should advance the player when at the same location");

        // Test no interaction when player is not at the same location
        result = crystal.interact(gameBoard, 7);
        assertEquals(InteractionResult.NONE, result, "TimeCrystal should not interact with player at a different location");
    }

    @Test
    public void testPortalPadInteraction() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        PortalPad pad = new PortalPad();
        gameBoard[5] = pad;

        // Test the PortalPad interaction
        pad.draw(); // Check the drawing functionality
    }
}



