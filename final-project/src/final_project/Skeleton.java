package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Skeleton extends GameObject {
	
	private Handler handler;
	private Texture texture = new Texture();
	
	private int time = 0;	
	private int x_, y_;
	
	public Skeleton(int x, int y, int health, ID id, Handler handler) {
		super(x, y, health, id);
		this.handler = handler;
	}

	public void tick() {
		x_ = getX();
		y_ = getY();
		x_ += getVelX() * 2.5;
		y_ += getVelY() * 2.5;
		setX(x_);
		setY(y_);
		
		for(GameObject obj : handler.object) {
			if(obj.getID() == ID.Player)
				moveToPlayer(obj);
		}
		
		if(health <= 0) 
			handler.removeObject(this);
		
	}

	public void render(Graphics g) {
		time += 1;
		if(time >= 180)
			time = 0;

		if(velY > 0)
			g.drawImage(texture.skeletonDown[(int)time/60], x, y, null);
		else
			g.drawImage(texture.skeletonUp[(int)time/60], x, y, null);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,Texture.skeletonWidth, Texture.skeletonHeight);
	}
	
}
