package final_project;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game extends Canvas implements Runnable {
	
	public static int width = 800;
	public static int height = 800;
	
	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	
	private BufferedImageLoader loader = new BufferedImageLoader();
	private SpriteSheet ss;
	private BufferedImage floor = null;
	
	private int ticks = 0;
	private int numEnemies = 2;
	
	//private Camera camera;
	//static Texture texture;
	
	public Game() {
		new Window(width, height, "Ghost Game", this);
		start();
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		floor = loader.loadImage("/floorTile.png");		
		ss = new SpriteSheet(floor);		
		floor = ss.grabImage(1, 1, 127, 127);
		
		handler.addObject(new Player(400, 400, 100, ID.Player, handler));
		
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
		handler.tick();
		if(handler.object.size() == 1)
			handler.enemyFactory();
		if(ticks >= 500) {
			for(int i = 0; i < numEnemies; i++)
				handler.enemyFactory();
			ticks = 0;
			numEnemies+=1;
		}
		ticks++;
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//Draws the background
		for(int xx = 0; xx < 30*72; xx+=32)
			for(int yy = 0; yy < 30*72; yy+=32)			
				g.drawImage(floor, xx, yy, null);
		//
		
		handler.render(g);
		g.dispose();
		bs.show();
		
	}

	public static void main(String args[]) {
		new Game();
	}

}
