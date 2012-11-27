package Tests.enumTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.PlayerSize;

public class PlayerSizeTest extends TestCase{

	private PlayerSize mGP;

	@Before
	public void setUp() throws Exception {
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	mGP = PlayerSize.BIG;
	assertEquals(mGP, PlayerSize.BIG);
	mGP = PlayerSize.LITTLE;
	assertEquals(mGP, PlayerSize.LITTLE);
	mGP = PlayerSize.NORMAL;
	assertEquals(mGP, PlayerSize.NORMAL);
	}

}
