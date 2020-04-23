package final_project;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	//private Camera camera;
	//static Texture texture;
	
	public Game() {
		new Window(800, 800, "Final Project", this);
		start();
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		handler.addObject(new Player(50, 50, ID.Player, handler));
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} 
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
			}
		}
		
		stop();		
		
	}
	
	private void tick() {
		for(int i = 0; i < handler.object.size(); i++) {
			//camera stuff would go here
		}
		handler.tick();
		
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		handler.render(g);
		g.dispose();
		bs.show();
		
	}

	public static void main(String args[]) {
		new Game();
	}

}