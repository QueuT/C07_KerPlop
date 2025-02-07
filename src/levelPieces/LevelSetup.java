package levelPieces;

import java.util.ArrayList;
import java.util.Random;

import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.Moveable;

import levelPieces.GamePiece;


public class LevelSetup {
	//Instance Variables
	private Drawable[] gameBoard;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private Random rand;
	
	//Creates the level data. Constructor
	public LevelSetup() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		rand = new Random();
	}
	
	// createLevel method
    public void createLevel(int levelNum) {
        // Reset the board before creating the level
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = null;  // makes sure empty at the start bc we use create level multi[le times
        }
        
        // Use levelNum to differentiate the levels STILL NOT DONE!!!!!!!!!!!!!!
        switch (levelNum) {
            case 1:
                setupLevelPieces1();
                break;
            case 2:
                setupLevelPieces2();
                break;
        }
    }
    //
    
    private void setupLevelPieces1() {
        // Drawable-only piece (Does not interact)
        Drawable portalPad = new PortalPad();  

        // Moveable pieces (2 total)
        Moveable shadowCrawler = new ShadowCrawler();  
        Moveable rogueBeast = new RogueBeast();      

        // Non-Moveable but Interacting pieces (4 total)
        GamePiece timeCrystal = new TimeCrystal();    
        GamePiece ghostArcher = new GhostArcher();    
        GamePiece mysticGuardian = new MysticGuardian();    

        // Add Drawable piece
        addRandomPiece(portalPad);

        // Add Moveable pieces
        addRandomPiece(shadowCrawler);
        movingPieces.add(shadowCrawler);

        addRandomPiece(rogueBeast);
        movingPieces.add(rogueBeast);

        // Add Interacting pieces
        addRandomPiece(timeCrystal);
        interactingPieces.add(timeCrystal);

        addRandomPiece(ghostArcher);
        interactingPieces.add(ghostArcher);

        addRandomPiece(mysticGuardian);
        interactingPieces.add(mysticGuardian);
    }


    private void setupLevelPieces2() {
        // Drawable-only piece
        Drawable portalPad = new PortalPad();  

        // Moveable pieces
        Moveable shadowCrawler = new ShadowCrawler();  
        Moveable rogueBeast = new RogueBeast();      

        // Non-Moveable but Interacting pieces
        GamePiece timeCrystal1 = new TimeCrystal();    
        GamePiece timeCrystal2 = new TimeCrystal();    
        GamePiece ghostArcher = new GhostArcher();    
        GamePiece mysticGuardian = new MysticGuardian();    

        // Add Drawable piece
        addRandomPiece(portalPad);

        // Add Moveable pieces
        addRandomPiece(shadowCrawler);
        movingPieces.add(shadowCrawler);

        addRandomPiece(rogueBeast);
        movingPieces.add(rogueBeast);

        // Add Interacting pieces
        addRandomPiece(timeCrystal1);
        interactingPieces.add(timeCrystal1);

        addRandomPiece(timeCrystal2);
        interactingPieces.add(timeCrystal2);

        addRandomPiece(ghostArcher);
        interactingPieces.add(ghostArcher);

        addRandomPiece(mysticGuardian);
        interactingPieces.add(mysticGuardian);
    }

    

    // Method to add a piece to the board at a random location STILL NOT DONE!!!!!!!!!!!!!!
    private void addRandomPiece(Drawable piece) {
        int position;
        do {
            position = rand.nextInt(GameEngine.BOARD_SIZE); // Pick a random spot
        } while (gameBoard[position] != null); // Ensure it's empty
        
        gameBoard[position] = piece; // Place the piece in the board
    }

    
    // Getters for the gameBoard, movingPieces, and interactingPieces this is used in GameEngine our whole goal
    public Drawable[] getBoard() {
        return gameBoard;
    }

    public ArrayList<Moveable> getMovingPieces() {
        return movingPieces;
    }

    public ArrayList<GamePiece> getInteractingPieces() {
        return interactingPieces;
    }
	
    public int getPlayerStartLoc() {
        return 10; // Initial location of the player
	 }
}
