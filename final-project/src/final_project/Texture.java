package final_project;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texture {
	private int playerWidth = 48;
	private int playerHeight = 48;
	private int enemySize = 48;
	
	public BufferedImage[] player = new BufferedImage[4];
	public BufferedImage[] enemy = new BufferedImage[4];
	
	SpriteSheet playerSheet;
	SpriteSheet enemySheet;
	
	private BufferedImage playerImage = null;
	private BufferedImage enemyImage = null;
	private Graphics g = null;
	
	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			playerImage = loader.loadImage("/player_ghost.png");
			enemyImage = loader.loadImage("/enemy.png");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		playerSheet = new SpriteSheet(playerImage);
		enemySheet = new SpriteSheet(enemyImage);
		
		getTextures(g);
		
	}
	
	private void getTextures(Graphics g) {
		player[0] = playerSheet.grabImage(240, 0, playerWidth, playerHeight);
		player[1] = playerSheet.grabImage(48, 48, playerWidth, playerHeight);
		player[2] = playerSheet.grabImage(48, 96, playerWidth, playerHeight);
		player[3] = playerSheet.grabImage(48, 144, playerWidth, playerHeight);
		
		enemy[0] = enemySheet.grabImage(0, 0, enemySize, enemySize);
//		enemy[1] = enemySheet.grabImage(48, 48, width, height);
//		enemy[2] = enemySheet.grabImage(48, 96, width, height);
//		enemy[3] = enemySheet.grabImage(48, 144, width, height);
	}
}
