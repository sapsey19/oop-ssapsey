package final_project;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texture {
	private int width = 36;
	private int height = 54;
	
	public BufferedImage[] player = new BufferedImage[1];
	
	SpriteSheet playerSheet;
	
	private BufferedImage playerImage = null;
	private Graphics g = null;
	
	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			playerImage = loader.loadImage("ghostguy.png");
			System.out.println("Found hat image");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		playerSheet = new SpriteSheet(playerImage);
		
		getTextures(g);
		
	}
	
	private void getTextures(Graphics g) {
		player[0] = playerSheet.grabImage(0, 0, width, height);
	}
}
