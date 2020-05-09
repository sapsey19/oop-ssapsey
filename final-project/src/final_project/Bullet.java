package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	
	public static int speed = 8;
	
	private Handler handler;
	private Texture texture = new Texture();
	
	private int direction;
	private int damage = 20;

	public Bullet(int x, int y, int direction, ID id, Handler handler) {
		super(x, y, id);
		this.direction = direction;
		this.handler = handler;
	}

	public void tick() {
		setVelX(speed);
		if(direction == 0) y += speed;
		if(direction == 1) x -= speed;
		if(direction == 2) x += speed;
		if(direction == 3) y -= speed;
		
		
		if(getX() > Game.width || getX() < -10 || getY() > Game.height || getY() < 0) //remove bullet if off screen
			handler.removeObject(this);
		collision();
	}

	public void render(Graphics g) {
		if(direction == 0) g.drawImage(texture.bullet[0], getX(), getY(), null);
		if(direction == 1) g.drawImage(texture.bullet[1], getX(), getY(), null);
		if(direction == 2) g.drawImage(texture.bullet[2], getX(), getY(), null);
		if(direction == 3) g.drawImage(texture.bullet[3], getX(), getY(), null);
	}
	
	public void collision() {
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
		return new Rectangle(getX(), getY(), Texture.bulletWidth, Texture.bulletHeight);
	}

}
