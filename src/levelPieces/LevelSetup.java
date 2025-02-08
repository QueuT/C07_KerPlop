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

        //Random Location Number Generator for parameters
        Random rand = new Random();
        
        // Moveable pieces (2 total)
        int shadowCrawlerLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        Moveable shadowCrawler = new ShadowCrawler(shadowCrawlerLocation);
        
        int rogueBeastLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        Moveable rogueBeast = new RogueBeast(rogueBeastLocation);      

        // Non-Moveable but Interacting pieces (4 total)
        int timeCrystalLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        GamePiece timeCrystal = new TimeCrystal(timeCrystalLocation);    
        
        int ghostArcherLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        GamePiece ghostArcher = new GhostArcher(ghostArcherLocation);    
        
        int mysticGuardianLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        GamePiece mysticGuardian = new MysticGuardian(mysticGuardianLocation);    

        // Add Drawable piece
        addRandomPiece(portalPad);

        // Add Moveable pieces
        addRandomPieceMoveable(shadowCrawler);
        movingPieces.add(shadowCrawler);

        addRandomPieceMoveable(rogueBeast);
        movingPieces.add(rogueBeast);

        // Add Interacting pieces
        addRandomPiece(timeCrystal);
        interactingPieces.add(timeCrystal);

        addRandomPiece(ghostArcher);
        interactingPieces.add(ghostArcher);

        addRandomPiece(mysticGuardian);
        interactingPieces.add(mysticGuardian);
        
<<<<<<< HEAD
        interactingPieces.add((GamePiece) rogueBeast);
        interactingPieces.add((GamePiece) shadowCrawler);
=======
>>>>>>> 4bfd770d2ecb5c147bb5f8326c2ee1129fc727c3
    }


    private void setupLevelPieces2() {
        // Drawable-only piece
        Drawable portalPad = new PortalPad();  

        // Moveable pieces
        int shadowCrawlerLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        Moveable shadowCrawler = new ShadowCrawler(shadowCrawlerLocation);
        
        int rogueBeastLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        Moveable rogueBeast = new RogueBeast(rogueBeastLocation);    

        // Non-Moveable but Interacting pieces
        int timeCrystalLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        GamePiece timeCrystal1 = new TimeCrystal(timeCrystalLocation);    
        GamePiece timeCrystal2 = new TimeCrystal(timeCrystalLocation);    
        
        int ghostArcherLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        GamePiece ghostArcher = new GhostArcher(ghostArcherLocation);    
        
        int mysticGuardianLocation = rand.nextInt(GameEngine.BOARD_SIZE);
        GamePiece mysticGuardian = new MysticGuardian(mysticGuardianLocation);      

        // Add Drawable piece
        addRandomPiece(portalPad);

        // Add Moveable pieces
        addRandomPieceMoveable(shadowCrawler);
        movingPieces.add(shadowCrawler);

        addRandomPieceMoveable(rogueBeast);
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
        
<<<<<<< HEAD
        interactingPieces.add((GamePiece) rogueBeast);
        interactingPieces.add((GamePiece) shadowCrawler);
=======
>>>>>>> 4bfd770d2ecb5c147bb5f8326c2ee1129fc727c3
    }

    

    private void addRandomPiece(Drawable piece) {
        int position;
        do {
            position = rand.nextInt(GameEngine.BOARD_SIZE); // Pick a random spot
        } while (gameBoard[position] != null); // Ensure it's empty
        
        // If the piece is a GamePiece, update its location
        if (piece instanceof GamePiece) {
            ((GamePiece) piece).setLocation(position);
        }
        
        gameBoard[position] = piece; // Place the piece in the board
    }

    private void addRandomPieceMoveable(Moveable piece) {
        int position;
        do {
            position = rand.nextInt(GameEngine.BOARD_SIZE); // Pick a random spot
        } while (gameBoard[position] != null); // Ensure it's empty
        
        // If the piece is a GamePiece, update its location
        if (piece instanceof GamePiece) {
            ((GamePiece) piece).setLocation(position);
        }
        
        gameBoard[position] = (Drawable) piece; // Place the piece in the board
    }


    
    // Getters for the gameBoard, movingPieces, and interactingPieces this is used in GameEngine our whole goal
    
    public void rebuildBoard() {
        // Create a new board array of the proper size.
        Drawable[] updatedBoard = new Drawable[GameEngine.BOARD_SIZE];
        
        // Place each moveable piece based on its current location.
        for (Moveable piece : movingPieces) {
            int pos = ((GamePiece) piece).getLocation();
            updatedBoard[pos] = (Drawable) piece;
        }
        
        // Place each interacting piece based on its current location.
        // If the spot is already occupied (for example, by a moveable piece), 
        // you might choose a rule (here, we only place the interacting piece if the spot is empty).
        for (GamePiece piece : interactingPieces) {
            int pos = piece.getLocation();
            if (updatedBoard[pos] == null) {
                updatedBoard[pos] = piece;
            }
        }
        
        // Optionally, if you maintain a list for Drawable-only pieces, place them as well.
        
        // Update the internal gameBoard with the new board.
        this.gameBoard = updatedBoard;
    }
    
    public void updateBoardAfterMove() {
        rebuildBoard();
    }

    public Drawable[] getBoard() {
        // Rebuild the board based on the current locations.
        rebuildBoard();
        // Return the updated board.
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
