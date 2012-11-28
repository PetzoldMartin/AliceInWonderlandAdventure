package Tests.enumTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

public class GameStatusTest extends TestCase{

	private GameStatus mGP;

	@Before
	public void setUp() throws Exception {
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	mGP = GameStatus.RUN;
	assertEquals(mGP, GameStatus.RUN);
	mGP = GameStatus.STOP;
	assertEquals(mGP, GameStatus.STOP);
	mGP = GameStatus.RESTART;
	assertEquals(mGP, GameStatus.RESTART);
	}

}
