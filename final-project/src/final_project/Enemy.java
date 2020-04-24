package final_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy extends GameObject {
	
	private Handler handler;
	private Texture texture = new Texture();
	private boolean follow = false;

	public Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		int moveToX = 0;
		int moveToY = 0;
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if(temp.getID() == ID.Player) {
				if(getEnemyRange().intersects(temp.getBounds()))
					 follow = true;
				else 
					follow = false;
				moveToX = temp.getX();
				moveToY = temp.getY();
			}
		}
		
		int diffX = moveToX - x;
		int diffY = moveToY - y;

		float angle = (float)Math.atan2(diffY, diffX);
		if(follow) {
			x += 2 * Math.cos(angle);
			y += 2 * Math.sin(angle);
		}
		
	}

	public void render(Graphics g) {
		if(x > 0)
			g.drawImage(texture.enemy[0], x, y, null);
		else if(velX < 0)
			g.drawImage(texture.enemy[1], x, y, null);
		else if(velY > 0)
			g.drawImage(texture.enemy[2], x, y, null);
		else if(velY < 0)
			g.drawImage(texture.enemy[3], x, y, null);
		Graphics2D g2d = (Graphics2D) g;
		
		//draws collision boxes
		g.setColor(Color.green);
		g2d.draw(getEnemyRange());
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	
	public Rectangle getEnemyRange() {
		return new Rectangle(x-64 , y-64 , 128*4, 128*4);
	}
	
}
