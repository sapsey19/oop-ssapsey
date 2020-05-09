package final_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	private Handler handler;
	private int x_, y_;
	
	public Texture texture = new Texture();
	
	public static int lastPressed = 0; // 0 is down, 1 is left, 2 is right, 3 is up 
	private int walkCount = 0;
	
	private int fireDelay = 0;
	boolean died = false;
	
	public Player(int x, int y, int health, ID id, Handler handler) {
		super(x, y, health, id);
		this.handler = handler;
	}

	public void tick() {
		x_ = getX();
		y_ = getY();
		x_ += getVelX();
		y_ += getVelY();
		setX(x_);
		setY(y_);
		
		collision();
		
		if(handler.isUp()) setVelY(-5);
		else if(!handler.isDown()) setVelX(0);
		
		if(handler.isDown()) setVelY(5);
		else if(!handler.isUp()) setVelY(0);
		
		if(handler.isRight()) setVelX(5);
		else if(!handler.isLeft()) setVelX(0);
		
		if(handler.isLeft()) setVelX(-5);
		else if(!handler.isRight()) setVelX(0);
		
		
		if(handler.isFire() && fireDelay >= 10) {
			if(handler.isDown() || lastPressed == 0) 
				handler.addObject(new Bullet(x+20, y, 0, ID.Bullet, handler));
			else if(handler.isLeft() || lastPressed == 1) 
				handler.addObject(new Bullet(x, y+20, 1, ID.Bullet, handler));
			else if(handler.isRight() || lastPressed == 2) 
				handler.addObject(new Bullet(x, y+20, 2, ID.Bullet, handler));
			else if(handler.isUp() || lastPressed == 3) 
				handler.addObject(new Bullet(x+20, y, 3, ID.Bullet, handler));
			fireDelay = 0;
		}
		fireDelay++;
		
		if(getX() > 800)
			setX(-40);
		if(getX() < -48)
			setX(792);
		if(getY() < -48)
			setY(792);
		if(getY() > 800)
			setY(-40);
		collision();
		
	}

	public void render(Graphics g) {
		if(walkCount >= 180)
			walkCount = 0;
		
		if(handler.isDown()) {
			g.drawImage(texture.playerDown[(int)walkCount/60], x, y, null);
			lastPressed = 0;
			walkCount++;
		}
		else if(handler.isUp()) {
			g.drawImage(texture.playerUp[(int)walkCount/60], x, y, null);
			lastPressed = 3;
			walkCount++;
		}
		else if(handler.isLeft()) {
			g.drawImage(texture.playerLeft[(int)walkCount/60], x, y, null);
			lastPressed = 1;
			walkCount++;
		}
		else if(handler.isRight()) {
			g.drawImage(texture.playerRight[(int)walkCount/60], x, y, null);
			lastPressed = 2;
			walkCount++;
		}
		
		
		if(velX == 0 && velY == 0) {
			if(lastPressed == 0) g.drawImage(texture.playerDown[0], x, y, null);
			if(lastPressed == 1) g.drawImage(texture.playerLeft[0], x, y, null);
			if(lastPressed == 2) g.drawImage(texture.playerRight[0], x, y, null);
			if(lastPressed == 3) g.drawImage(texture.playerUp[0], x, y, null);
		}
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject object = handler.object.get(i);
			if(object.getID() == ID.Skeleton || object.getID() == ID.Zombie) {
				if(getBounds().intersects(object.getBounds()) && !died) {
					handler.removeObject(this);
					System.out.println("YOU DIED. Final Score: " + handler.getScore());
					died = true;
				}
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(getX() + 5, getY(), Texture.playerWidth - 10, Texture.playerHeight);
	}
}
