package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x, y;
	protected double velX = 0, velY = 0;
	protected ID id;
	protected int health;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public GameObject(int x, int y, int health, ID id) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void decreaseHealth(int amount) { health -= amount; }
	
	public void moveToPlayer(GameObject player) {
		int moveToX = 0, moveToY = 0;		

		moveToX = player.getX();
		moveToY = player.getY();		
		
		int diffX = moveToX - x;
		int diffY = moveToY - y;
		float angle = (float)Math.atan2(diffY, diffX);
		
		velX = (double) (2 * Math.cos(angle)/2);
		velY = (double) (2 * Math.sin(angle)/2);
	}
	
	public int getX() {	return x; }
	public int getY() { return y; }
	public double getVelX() { return velX; }
	public double getVelY() { return velY; }
	public int getHealth() { return health; }
	public ID getID() { return id; }
	
	public void setX(int x) { this.x = x; }	
	public void setY(int y) { this.y = y; }
	public void setVelX(double velX) { this.velX = velX; }	
	public void setVelY(double velY) { this.velY = velY; }
	public void setHealth(int health) { this.health = health; }
	public void setID(ID id) {  this.id = id; }
}
