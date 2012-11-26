package de.fh_zwickau.oose.zuul;

import gameBuilding.LevelCreator;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.PlayerSize;

public class PlayerTest extends TestCase{
	Player player;
	private LevelCreator levelcreator;
	private Room room;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		levelcreator= new LevelCreator();
		room= levelcreator.getStartRoom();
		
		
	}

	@Test
	public void testPlayer() {
		Assert.assertNull(player.getCurrentRoom());
		
	}

	@Test
	public void testGetSize(){
		assertEquals(PlayerSize.NORMAL,player.getSize());
	}

	@Test
	public void testSetSize(){
		player.setSize(PlayerSize.LITTLE);
		assertEquals(PlayerSize.LITTLE,player.getSize());
		player.setSize(PlayerSize.BIG);
		assertEquals(PlayerSize.BIG,player.getSize());
		player.setSize(PlayerSize.BIG);
		assertEquals(PlayerSize.BIG,player.getSize());
	}
	@Test
	public void testWalk() {
		player.setCurrentRoom(room);
		player.walk("osten");
		
		assertFalse(levelcreator.getStartRoom().equals(player.getCurrentRoom()));
		player.walk("westen");
		assertEquals(levelcreator.getStartRoom(), player.getCurrentRoom());
		player.walk("Schwachsinn");
		assertEquals(levelcreator.getStartRoom(), player.getCurrentRoom());
	}




}
