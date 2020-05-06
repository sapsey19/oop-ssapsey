package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ID id;
	protected int health;
	
	public GameObject(int x, int y, int health, ID id) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public void decreaseHealth(int damage) { this.health = health - damage; }
	
	public int getX() {	return x; }
	public int getY() { return y; }
	public int getHealth() { return health; }
	public float getVelX() { return velX; }
	public float getVelY() { return velY; }
	public ID getID() { return id; }
	
	public void setX(int x) { this.x = x; }	
	public void setY(int y) { this.y = y; }
	public void setHealth(int health) { this.health = health; }
	public void setVelX(float velX) { this.velX = velX; }	
	public void setVelY(float velY) { this.velY = velY; }	
	public void setID(ID id) {  this.id = id; }
}
