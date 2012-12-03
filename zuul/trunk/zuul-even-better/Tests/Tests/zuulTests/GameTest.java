package Tests.zuulTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;




public class GameTest extends TestCase{
	
	Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void testGame() {
		Assert.assertNotNull(game);
		Assert.assertNotNull(game.getParser());
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
