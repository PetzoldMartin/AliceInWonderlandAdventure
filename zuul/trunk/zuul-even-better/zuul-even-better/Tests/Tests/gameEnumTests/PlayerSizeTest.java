package Tests.gameEnumTests;

import gameEnums.PlayerSize;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
	mGP = PlayerSize.GROSS;
	assertEquals(mGP, PlayerSize.GROSS);
	mGP = PlayerSize.KLEIN;
	assertEquals(mGP, PlayerSize.KLEIN);
	mGP = PlayerSize.NORMAL;
	assertEquals(mGP, PlayerSize.NORMAL);
	}

}
