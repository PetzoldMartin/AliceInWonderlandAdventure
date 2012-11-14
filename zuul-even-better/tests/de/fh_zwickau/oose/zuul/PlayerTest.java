package de.fh_zwickau.oose.zuul;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest extends TestCase{
	Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player();
	}

	@Test
	public void testPlayer() {
		Assert.assertNull(player.getCurrentRoom());
		
	}


	@Test
	public void testWalk() {
		player.walk("osten");
		//Assert.assert
	}




}
