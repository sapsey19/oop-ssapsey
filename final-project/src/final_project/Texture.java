package final_project;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texture {
	private int playerWidth = 48;
	private int playerHeight = 48;
	private int zombieWidth = 32;
	private int zombieHeight = 42;
	
	public BufferedImage[] playerDown = new BufferedImage[4];
	public BufferedImage[] playerLeft = new BufferedImage[4];
	public BufferedImage[] playerRight = new BufferedImage[4];
	public BufferedImage[] playerUp = new BufferedImage[4];
	
	public BufferedImage[] zombieDown = new BufferedImage[3];
	public BufferedImage[] zombieLeft = new BufferedImage[3];
	public BufferedImage[] zombieRight = new BufferedImage[3];
	public BufferedImage[] zombieUp = new BufferedImage[3];
	
	SpriteSheet playerSheet;
	SpriteSheet zombieSheet;
	
	private BufferedImage playerImage = null;
	private BufferedImage zombieImage = null;
	private Graphics g = null;
	
	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			playerImage = loader.loadImage("/player_ghost.png");
			zombieImage = loader.loadImage("/zombies.png");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		playerSheet = new SpriteSheet(playerImage);
		zombieSheet = new SpriteSheet(zombieImage);
		
		getTextures(g);
		
	}
	
	private void getTextures(Graphics g) {
		playerDown[0] = playerSheet.grabImage(0, 0, playerWidth, playerHeight);
		playerDown[1] = playerSheet.grabImage(48, 0, playerWidth, playerHeight);
		playerDown[2] = playerSheet.grabImage(96, 0, playerWidth, playerHeight);
		playerDown[3] = playerSheet.grabImage(144, 0, playerWidth, playerHeight);
		
		playerLeft[0] = playerSheet.grabImage(0, 48, playerWidth, playerHeight);
		playerLeft[1] = playerSheet.grabImage(48, 48, playerWidth, playerHeight);
		playerLeft[2] = playerSheet.grabImage(96, 48, playerWidth, playerHeight);
		playerLeft[3] = playerSheet.grabImage(144, 48, playerWidth, playerHeight);
		
		playerRight[0] = playerSheet.grabImage(0, 96, playerWidth, playerHeight);
		playerRight[1] = playerSheet.grabImage(48, 96, playerWidth, playerHeight);
		playerRight[2] = playerSheet.grabImage(96, 96, playerWidth, playerHeight);
		playerRight[3] = playerSheet.grabImage(144, 96, playerWidth, playerHeight);
		
		playerUp[0] = playerSheet.grabImage(0, 144, playerWidth, playerHeight);
		playerUp[1] = playerSheet.grabImage(48, 144, playerWidth, playerHeight);
		playerUp[2] = playerSheet.grabImage(96, 144, playerWidth, playerHeight);
		playerUp[3] = playerSheet.grabImage(144, 144, playerWidth, playerHeight);
		
		//down
		zombieDown[0] = zombieSheet.grabImage(0, 0, zombieWidth, zombieHeight);
		zombieDown[1] = zombieSheet.grabImage(32, 0, zombieWidth, zombieHeight);
		zombieDown[2] = zombieSheet.grabImage(64, 0, zombieWidth, zombieHeight);
		//left
		zombieLeft[0] = zombieSheet.grabImage(0, 42, zombieWidth, zombieHeight);
		zombieLeft[1] = zombieSheet.grabImage(32, 42, zombieWidth, zombieHeight);
		zombieLeft[2] = zombieSheet.grabImage(64, 42, zombieWidth, zombieHeight);
		
		zombieRight[0] = zombieSheet.grabImage(0, 84, zombieWidth, zombieHeight);
		zombieRight[1] = zombieSheet.grabImage(32, 84, zombieWidth, zombieHeight);
		zombieRight[2] = zombieSheet.grabImage(64, 84, zombieWidth, zombieHeight);
		
		zombieUp[0] = zombieSheet.grabImage(0, 126, zombieWidth, zombieHeight -2);
		zombieUp[1] = zombieSheet.grabImage(32, 126, zombieWidth, zombieHeight - 2);
		zombieUp[2] = zombieSheet.grabImage(64, 126, zombieWidth, zombieHeight - 2);
	}
}
