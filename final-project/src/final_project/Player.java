package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	private Handler handler;
	private float velX = 0, velY = 0;
	
	private int width = 48;
	private int height = 48;
	
	public Texture texture = new Texture();
	
	public int lastPressed; //0 == Up, 1 == Down, 2 == Right, 3 == Left
	
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
		if(handler.isDown()) g.drawImage(texture.player[0], x, y, null);
		else if(handler.isLeft()) g.drawImage(texture.player[1], x, y ,null);
		else if(handler.isRight()) g.drawImage(texture.player[2], x, y ,null);
		else if(handler.isUp()) g.drawImage(texture.player[3], x, y ,null);
		
		if(!handler.isDown() && !handler.isUp() && !handler.isRight() && !handler.isLeft()) {
			if(lastPressed == 0) g.drawImage(texture.player[3], x, y, null);
			if(lastPressed == 1) g.drawImage(texture.player[0], x, y, null);
			if(lastPressed == 2) g.drawImage(texture.player[1], x, y, null);
			if(lastPressed == 3) g.drawImage(texture.player[2], x, y, null);
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
