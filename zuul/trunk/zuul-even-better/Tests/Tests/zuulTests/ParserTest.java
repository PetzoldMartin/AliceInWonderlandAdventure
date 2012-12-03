package Tests.zuulTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.CommandWords;
import zuulCore.Game;
import zuulCore.Parser;
import executeAble.commands.NullCommand;


public class ParserTest extends TestCase{
	Parser parser;
	@SuppressWarnings("unused")
	private Game game;
	@SuppressWarnings("unused")
	private CommandWords cw;

	@Before
	public void setUp() throws Exception {
		game = new Game();
		cw = new CommandWords();
	}

	@Test
	public void testParser() {
		Assert.assertNotNull(parser);
	}

	@Test
	public void testGetCommand() {
		assertEquals(parser.getCommand("").getClass(),new NullCommand().getClass());
		assertEquals(parser.getCommand("").getSecondWord(),new NullCommand().getSecondWord());
		assertEquals(parser.getCommand("").getThirdWord(),new NullCommand().getThirdWord());
	}
	
	@Test
	public void testShowCommands() {
		//funktioniert wen commands.showall funktioniert
	}

}
