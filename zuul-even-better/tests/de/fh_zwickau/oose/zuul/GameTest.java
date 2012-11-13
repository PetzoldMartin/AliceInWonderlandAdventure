package de.fh_zwickau.oose.zuul;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void testGame() {
		Assert.assertNotNull(game);
		Assert.assertNotNull(game.getPlarser());
		Assert.assertNotNull(game.getLC());
		Assert.assertNotNull(game.getPlayer());
	}

	@Test
	public void testMain() {
		//wtf wer testet das schon? oO
	}

	@Test
	public void testPlay() {
		//Haupschleife testen? wie?^^
	}

}
