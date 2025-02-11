package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import gameEngine.Drawable;
import levelPieces.RogueBeast;
import levelPieces.ShadowCrawler;
import gameEngine.GameEngine;

public class TestMovingPieces {
//I HAVE TO UPLOAD JUNIT 5 on my system!
    @Test
    public void testShadowCrawlerMovement() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        ShadowCrawler crawler = new ShadowCrawler(15);
        gameBoard[15] = crawler;
        
        int ogLocation = crawler.getLocation();
        boolean hasMoved = false;
        
        // Move it multiple times and check positions
        for (int i = 0; i < 100; i++) {
            //int prevLoc = crawler.getLocation();
            crawler.move(gameBoard, 10); // Assuming player is at position 10
            if (crawler.getLocation() != ogLocation) {
            	hasMoved = true;
            	break;
            }
            //int newLoc = crawler.getLocation();

            // Ensure it moves but stays within bounds
            //assertNotEquals(prevLoc, newLoc, "ShadowCrawler should move");
            //assertTrue(newLoc >= 0 && newLoc < GameEngine.BOARD_SIZE, "ShadowCrawler moved out of bounds");
        }
        assertTrue(hasMoved, "ShadowCrawler did not move after 100 attempts!");
    }
    
    @Test
    public void testRogueBeastMovement() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        RogueBeast beast = new RogueBeast(7);
        gameBoard[7] = beast;

        int ogLocation = beast.getLocation();
        boolean hasMoved = false;
        
        for (int i = 0; i < 100; i++) {
            beast.move(gameBoard, 12);
            if (beast.getLocation() != ogLocation) {
            	hasMoved = true;
            	break;
            }    
        }
        assertTrue(hasMoved, "RogueBeast did not move after 100 attempts!");    
    }
}
