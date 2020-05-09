package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import final_project.Bullet;
import final_project.Handler;
import final_project.ID;
import final_project.Player;

class GameObjectTests {
	
	@Test
	void testPlayer( ) {
		Handler handler = new Handler();
		Player player = new Player(500, 400, 20, ID.Player, handler);
		assertEquals(player.getX(), 500);
		assertEquals(player.getY(), 400);
		assertEquals(player.getHealth(), 20);
		assertEquals(player.getID(), ID.Player);
		
		player.setHealth(100);
		assertEquals(player.getHealth(), 100);
		player.decreaseHealth(40);
		assertEquals(player.getHealth(), 60);
	}

	@Test
	void testBullet() {
		Handler handler = new Handler();
		Bullet bullet = new Bullet(10, 0, 0, ID.Bullet, handler);
		bullet.setVelX(5);
		bullet.setVelY(5);
		assertEquals(bullet.getX(), 10);
		assertEquals(bullet.getY(), 0);
		assertEquals(bullet.getVelX(), 5);
		assertEquals(bullet.getVelY(), 5);
		assertEquals(bullet.getID(), ID.Bullet);
	}

}
