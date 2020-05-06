package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	
	private float velX, velY;
	private Handler handler;
	private Texture texture = new Texture();

	public Bullet(int x, int y, float velX2, float velY2, ID id, Handler handler) {
		super(x, y, id);
		this.velX = velX2;
		this.velY = velY2;
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x > Game.width || x < 0 || y > Game.height || y < 0) //remove bullet if off screen
			handler.removeObject(this);
	}

	public void render(Graphics g) {
		g.drawImage(texture.bullet[0], x, y, null);
	}

	public Rectangle getBounds() {
		return null;
	}

}
