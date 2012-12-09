package Tests.ExecuteAbleTests;

import static org.junit.Assert.*;
import executeAble.ExecuteAble;
import gameEnums.GameStatus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Player;

public class ExecuteAbleTest {

	private ExecuteAble executeAble;
	private Player player;

	@Before
	public void setUp() throws Exception {
		executeAble=new ExecuteAble() {
			
			@Override
			public GameStatus execute(Player player) {
				return null;
			}
		};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecuteAble() {
		assertNotNull(executeAble);
	}

	@Test
	public void testExecute() {
		assertNull(executeAble.execute(player));
	}

	@Test
	public void testSetSecondWord() {
		assertNull(executeAble.getSecondWord());
		executeAble.setSecondWord("test");
		assertNotNull(executeAble.getSecondWord());
	}

	@Test
	public void testSetThirdWord() {
		assertNull(executeAble.getThirdWord());
		executeAble.setThirdWord("test");
		assertNotNull(executeAble.getThirdWord());
	}

	@Test
	public void testGetSecondWord() {
		assertNull(executeAble.getSecondWord());
		executeAble.setSecondWord("test");
		assertEquals(executeAble.getSecondWord(),"test");
	}

	@Test
	public void testGetThirdWord() {
		assertNull(executeAble.getThirdWord());
		executeAble.setThirdWord("test");
		assertEquals(executeAble.getThirdWord(),"test");
	}

	@Test
	public void testHasSecondWord() {
		assertFalse(executeAble.hasSecondWord());
		executeAble.setSecondWord("test");
		assertTrue(executeAble.hasSecondWord());
	}

	@Test
	public void testHasThirdWord() {
		assertFalse(executeAble.hasThirdWord());
		executeAble.setThirdWord("test");
		assertTrue(executeAble.hasThirdWord());
	}

}
