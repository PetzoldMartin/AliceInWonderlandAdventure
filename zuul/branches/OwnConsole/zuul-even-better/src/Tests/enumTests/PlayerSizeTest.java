package Tests.enumTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.PlayerSize;

public class PlayerSizeTest extends TestCase{

	private PlayerSize GP;

	@Before
	public void setUp() throws Exception {
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	GP = PlayerSize.BIG;
	assertEquals(GP, PlayerSize.BIG);
	GP = PlayerSize.LITTLE;
	assertEquals(GP, PlayerSize.LITTLE);
	GP = PlayerSize.NORMAL;
	assertEquals(GP, PlayerSize.NORMAL);
	}

}
