package final_project;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texture {
	private int playerWidth = 48;
	private int playerHeight = 48;
	private int zombieWidth = 30;
	private int zombieHeight = 42;
	private int skeletonWidth = 30;
	private int skeletonHeight = 48;
	private int bulletWidth = 10;
	private int bulletHeight = 28;
	
	public BufferedImage[] playerDown = new BufferedImage[3];
	public BufferedImage[] playerLeft = new BufferedImage[3];
	public BufferedImage[] playerRight = new BufferedImage[3];
	public BufferedImage[] playerUp = new BufferedImage[3];
	
	public BufferedImage[] zombieDown = new BufferedImage[3];
	public BufferedImage[] zombieUp = new BufferedImage[3];
	
	public BufferedImage[] skeletonDown = new BufferedImage[3];
	public BufferedImage[] skeletonUp = new BufferedImage[3];
	
	public BufferedImage[] bullet = new BufferedImage[4];
	
	SpriteSheet playerSheet;
	SpriteSheet zombieSheet;
	SpriteSheet skeletonSheet;
	SpriteSheet bulletSheet;
	
	private BufferedImage playerImage = null;
	private BufferedImage zombieImage = null;
	private BufferedImage skeletonImage = null;
	private BufferedImage bulletImage = null;
	
	private Graphics g = null;
	
	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			playerImage = loader.loadImage("/player_ghost.png");
			zombieImage = loader.loadImage("/zombies.png");
			skeletonImage = loader.loadImage("/skeleton.png");
			bulletImage = loader.loadImage("/bullet.png");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		playerSheet = new SpriteSheet(playerImage);
		zombieSheet = new SpriteSheet(zombieImage);
		skeletonSheet = new SpriteSheet(skeletonImage);
		bulletSheet = new SpriteSheet(bulletImage);
		
		getTextures(g);
		
	}
	
	private void getTextures(Graphics g) {
		playerDown[0] = playerSheet.grabImage(0, 0, playerWidth, playerHeight);
		playerDown[1] = playerSheet.grabImage(48, 0, playerWidth, playerHeight);
		playerDown[2] = playerSheet.grabImage(96, 0, playerWidth, playerHeight);
				
		playerLeft[0] = playerSheet.grabImage(0, 48, playerWidth, playerHeight);
		playerLeft[1] = playerSheet.grabImage(48, 48, playerWidth, playerHeight);
		playerLeft[2] = playerSheet.grabImage(96, 48, playerWidth, playerHeight);
				
		playerRight[0] = playerSheet.grabImage(0, 96, playerWidth, playerHeight);
		playerRight[1] = playerSheet.grabImage(48, 96, playerWidth, playerHeight);
		playerRight[2] = playerSheet.grabImage(96, 96, playerWidth, playerHeight);
				
		playerUp[0] = playerSheet.grabImage(0, 144, playerWidth, playerHeight);
		playerUp[1] = playerSheet.grabImage(48, 144, playerWidth, playerHeight);
		playerUp[2] = playerSheet.grabImage(96, 144, playerWidth, playerHeight);
				
		zombieDown[0] = zombieSheet.grabImage(0, 0, zombieWidth, zombieHeight);
		zombieDown[1] = zombieSheet.grabImage(32, 0, zombieWidth, zombieHeight);
		zombieDown[2] = zombieSheet.grabImage(64, 0, zombieWidth, zombieHeight);
		
		zombieUp[0] = zombieSheet.grabImage(0, 126, zombieWidth, zombieHeight);
		zombieUp[1] = zombieSheet.grabImage(32, 126, zombieWidth, zombieHeight);
		zombieUp[2] = zombieSheet.grabImage(64, 126, zombieWidth, zombieHeight);
		
		skeletonDown[0] = skeletonSheet.grabImage(0, 0, skeletonWidth, skeletonHeight);
		skeletonDown[1] = skeletonSheet.grabImage(31, 0, skeletonWidth, skeletonHeight);
		skeletonDown[2] = skeletonSheet.grabImage(62, 0, skeletonWidth, skeletonHeight);
		
		skeletonUp[0] = skeletonSheet.grabImage(0, 152, skeletonWidth, skeletonHeight);
		skeletonUp[1] = skeletonSheet.grabImage(31, 152, skeletonWidth, skeletonHeight);
		skeletonUp[2] = skeletonSheet.grabImage(62, 152, skeletonWidth, skeletonHeight);
		
		bullet[0] = bulletSheet.grabImage(0, 0, bulletWidth, bulletHeight);
		
	}
}
