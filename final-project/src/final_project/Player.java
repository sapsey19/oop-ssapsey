package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	private Handler handler;
	private float velX = 0, velY = 0;
	
	private int width = 48;
	private int height = 48;
	
	public Texture texture = new Texture();
	
	public int lastPressed = 1; // 0 is down, 1 is left, 2 is right, 3 is up 
	
	private int walkCount = 0;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
		
		if(x > 800)
			x = -40;
		if(x < -48)
			x = 792;
		if(y < -48)
			y = 792;
		if(y > 800)
			y = -40;
		
		//System.out.println(x);
	}

	public void render(Graphics g) {
		//g.drawRect(x, y, 50, 50);
		//g.setColor(Color.BLUE);
		//g.fillRect(x, y, 50, 50);
		if(walkCount >= 160)
			walkCount = 0;
		
		if(handler.isDown()) {
			g.drawImage(texture.playerDown[(int)walkCount/40], x, y, null);
			lastPressed = 0;
			walkCount++;
		}
		else if(handler.isUp()) {
			g.drawImage(texture.playerUp[(int)walkCount/40], x, y, null);
			lastPressed = 3;
			walkCount++;
		}
		if(handler.isLeft()) {
			g.drawImage(texture.playerLeft[(int)walkCount/40], x, y, null);
			lastPressed = 1;
			walkCount++;
		}
		else if(handler.isRight()) {
			g.drawImage(texture.playerRight[(int)walkCount/40], x, y, null);
			lastPressed = 2;
			walkCount++;
		}
		
		
		if(velX == 0 && velY == 0) {
			if(lastPressed == 0) g.drawImage(texture.playerDown[0], x, y, null);
			if(lastPressed == 1) g.drawImage(texture.playerLeft[1], x, y, null);
			if(lastPressed == 2) g.drawImage(texture.playerRight[2], x, y, null);
			if(lastPressed == 3) g.drawImage(texture.playerUp[3], x, y, null);
		}
	}
	
	private void collision() {
			
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int) ((int)y + (height/2-1)), (int)width/2, (int)height/2);
	}
	
	public void setLastPressed(int lastPressed) {
		this.lastPressed = lastPressed;
	}
	
//	public boolean isUp() { return up; }
//	public boolean isDown() { return down; }
//	public boolean isRight() { return right; }
//	public boolean isLeft() { return left; }
//	
//	public void setUp(boolean up) { this.up = up; }
//	public void setDown(boolean down) { this.down = down; }
//	public void setRight(boolean right) { this.right = right; }
//	public void setLeft(boolean left) { this.left = left; }
	
	

}
