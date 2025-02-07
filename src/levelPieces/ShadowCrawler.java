package levelPieces;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

import java.util.Random;

public class ShadowCrawler implements Moveable {
	
	private boolean isVisible; // Tracks the secret super power of invisibility 
	private Random rand; // Random generator when it's invisible or not
	
	//Constructor
	public ShadowCrawler(int location) {
		super(location);
		this.rand = new Random();
		this.isVisible = true;
	}
	
	//Move Shadowcrawler left or right randomly
	@Override
	public void move() {
		int direction = rand.nextBoolean() ? 1 : -1;
		setLocation(getLocation() + direction);
		
		is
	}
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
	}

}
