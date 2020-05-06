package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	
	public static int speed = 8;
	
	private float velX, velY;
	private Handler handler;
	private Texture texture = new Texture();
	
	private int direction;
	private int damage = 20;

	public Bullet(int x, int y, float velX2, float velY2, int direction, ID id, Handler handler) {
		super(x, y, 0, id);
		this.velX = velX2;
		this.velY = velY2;
		this.direction = direction;
		this.handler = handler;	
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x > Game.width || x < 0 || y > Game.height || y < 0) //remove bullet if off screen
			handler.removeObject(this);
		collision();
	}

	public void render(Graphics g) {
		if(direction == 0) g.drawImage(texture.bullet[0], x, y, null);
		if(direction == 1) g.drawImage(texture.bullet[1], x, y, null);
		if(direction == 2) g.drawImage(texture.bullet[2], x, y, null);
		if(direction == 3) g.drawImage(texture.bullet[3], x, y, null);
	}
	
	public void collision() {
//		for(GameObject object : handler.object) {
//			if(object.getID() == ID.Skeleton || object.getID() == ID.Zombie) {
//				if(getBounds().intersects(object.getBounds())) {
//					object.setHealth(object.getHealth() - 20);
//					handler.removeObject(this);
//				}
//			}
//		}
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject object = handler.object.get(i);
			if(object.getID() == ID.Skeleton || object.getID() == ID.Zombie) {
				if(getBounds().intersects(object.getBounds())) {
					object.decreaseHealth(damage);
					handler.removeObject(this);
				}
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, Texture.bulletWidth, Texture.bulletHeight);
	}

}
