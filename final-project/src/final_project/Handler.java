package final_project;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Handler {
	
	private boolean up = false;
	private boolean down = false;
	private boolean right = false;
	private boolean left = false;
	private boolean fire = false;
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public LinkedList<GameObject> isObject() {
		return object;
	}
	
	public void setObject(LinkedList<GameObject> object) {
		this.object = object;
	}
	
	public void tick() {
		for(int i =0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i =0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject tempObject) {
		object.add(tempObject);
	}
	
	public void removeObject(GameObject tempObject) {
		object.remove(tempObject);
	}
	
	//Factory design pattern for dynamically creating enemies
	public void enemyFactory() {
		Random r = new Random();
		int rand = r.nextInt(10);
		
		if(rand > 4)
			object.add(new Zombie(r.nextInt(800), r.nextInt(800), 100, ID.Zombie, this));
		else
			object.add(new Skeleton(r.nextInt(800), r.nextInt(800), 60, ID.Skeleton, this));
	}
	
	public boolean isUp() { return up; }
	public boolean isDown() { return down; }
	public boolean isRight() { return right; }
	public boolean isLeft() { return left; }
	public boolean isFire() { return fire; }
	
	public void setUp(boolean up) { this.up = up; }
	public void setDown(boolean down) { this.down = down; }
	public void setRight(boolean right) { this.right = right; }
	public void setLeft(boolean left) { this.left = left; }
	public void setFire(boolean fire) { this.fire = fire; }
}
