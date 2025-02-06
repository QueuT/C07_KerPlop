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
                setupLevelR();
                break;
            case 2:
                setupLevelR();
                break;
        }
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
	

	 

	
	
}
