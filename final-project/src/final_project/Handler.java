package final_project;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	private boolean up = false;
	private boolean down = false;
	private boolean right = false;
	private boolean left = false;
	
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
	
	//only setters and getters play down here... turn back.
	
	public boolean isUp() { return up; }
	public boolean isDown() { return down; }
	public boolean isRight() { return right; }
	public boolean isLeft() { return left; }
	
	public void setUp(boolean up) { this.up = up; }
	public void setDown(boolean down) { this.down = down; }
	public void setRight(boolean right) { this.right = right; }
	public void setLeft(boolean left) { this.left = left; }
}
