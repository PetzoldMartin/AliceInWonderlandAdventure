package de.fh_zwickau.oose.zuul;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

public class RoomTest extends TestCase{
	Room room;
	Room room2;

	@Before
	public void setUp() throws Exception {
		room = new Room("raum1");
		room2 = new Room("raum2", PlayerSize.NORMAL);
	}

	@Test
	public void testRoomStringPlayerSize() {
		Assert.assertNotNull(room);
		Assert.assertNotNull(room2);
		
	}



	@Test
	public void testSetExit() {
		room.setExit("Richtung", room2);
		Assert.assertNotNull(room.getExit("Richtung"));
		room2.setExit("Gegenrichtung", room);
		Assert.assertNotNull(room2.getExit("Gegenrichtung"));
	}


}
