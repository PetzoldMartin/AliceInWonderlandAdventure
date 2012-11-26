package Tests.enumTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

public class GameStatusTest extends TestCase{

	private GameStatus GP;

	@Before
	public void setUp() throws Exception {
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	GP = GameStatus.RUN;
	assertEquals(GP, GameStatus.RUN);
	GP = GameStatus.STOP;
	assertEquals(GP, GameStatus.STOP);
	GP = GameStatus.RESTART;
	assertEquals(GP, GameStatus.RESTART);
	}

}
