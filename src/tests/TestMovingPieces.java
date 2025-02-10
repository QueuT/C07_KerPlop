package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import gameEngine.Drawable;
import levelPieces.ShadowCrawler;
import gameEngine.GameEngine;

public class TestMovingPieces {
//I HAVE TO UPLOAD JUNIT 5 on my system!
    @Test
    public void testShadowCrawlerMovement() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        ShadowCrawler crawler = new ShadowCrawler(5);
        gameBoard[5] = crawler;
        
        // Move it multiple times and check positions
        for (int i = 0; i < 100; i++) {
            int prevLoc = crawler.getLocation();
            crawler.move(gameBoard, 10); // Assuming player is at position 10
            int newLoc = crawler.getLocation();

            // Ensure it moves but stays within bounds
            assertNotEquals(prevLoc, newLoc, "ShadowCrawler should move");
            assertTrue(newLoc >= 0 && newLoc < GameEngine.BOARD_SIZE, "ShadowCrawler moved out of bounds");
        }
    }
}
