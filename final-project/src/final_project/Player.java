package final_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	private Handler handler;
	private float velX = 0, velY = 0;
	
	//don't like this...
	private boolean up = false;
	private boolean down = false;
	private boolean right = false;
	private boolean left = false;
	///
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
		
		//System.out.println(x + ", " + y);
		
	}

	public void render(Graphics g) {
		g.drawRect(x, y, 50, 50);
		g.setColor(Color.BLUE);
		//g.fillRect(x, y, 50, 50);
	}
	
	private void collision() {
			
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
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
