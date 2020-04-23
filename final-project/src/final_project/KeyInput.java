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
		
		if(key == KeyEvent.VK_W) handler.setUp(true);
		if(key == KeyEvent.VK_S) handler.setDown(true);
		if(key == KeyEvent.VK_D) handler.setRight(true);
		if(key == KeyEvent.VK_A) handler.setLeft(true);
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) handler.setUp(false);
		if(key == KeyEvent.VK_S) handler.setDown(false);
		if(key == KeyEvent.VK_D) handler.setRight(false);
		if(key == KeyEvent.VK_A) handler.setLeft(false);
	}
}
