package final_project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	Handler handler;
	Player player;
	Game game;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			handler.setUp(true);
			player.setLastPressed(0);
		}
		if(key == KeyEvent.VK_S) {
			handler.setDown(true);
			player.setLastPressed(1);
		}
		if(key == KeyEvent.VK_D) {
			handler.setRight(true);
			player.setLastPressed(2);
		}
		if(key == KeyEvent.VK_A) {
			handler.setLeft(true);
			player.setLastPressed(3);
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) handler.setUp(false);
		if(key == KeyEvent.VK_S) handler.setDown(false);
		if(key == KeyEvent.VK_D) handler.setRight(false);
		if(key == KeyEvent.VK_A) handler.setLeft(false);
	}
}
