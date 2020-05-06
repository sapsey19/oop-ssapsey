package final_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Skeleton extends GameObject {
	
	private Handler handler;
	private Texture texture = new Texture();
	
	private int time = 0;
	
	private int diffX;
	private int diffY;
	
	public Skeleton(int x, int y, int health, ID id, Handler handler) {
		super(x, y, health, id);
		this.handler = handler;
	}

	public void tick() {
		int moveToX = 0;
		int moveToY = 0;
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if(temp.getID() == ID.Player) {
				moveToX = temp.getX();
				moveToY = temp.getY();
			}
		}
		
		diffX = moveToX - x;
		diffY = moveToY - y;
		float angle = (float)Math.atan2(diffY, diffX);
		
		velX = (float) (2 * Math.cos(angle));
		velY = (float) (2 * Math.sin(angle));
		
		if(health == 0) 
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
				
		//draws collision boxes
		//Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.red);
		//g2d.draw(getBounds());
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,Texture.skeletonWidth, Texture.skeletonHeight);
	}
	
}
