package Tests.zuulTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import commands.NullCommand;
import de.fh_zwickau.oose.zuul.CommandWords;
import de.fh_zwickau.oose.zuul.Game;
import de.fh_zwickau.oose.zuul.Parser;

public class ParserTest extends TestCase{
	Parser parser;
	@SuppressWarnings("unused")
	private Game game;
	@SuppressWarnings("unused")
	private CommandWords cw;

	@Before
	public void setUp() throws Exception {
		parser = new Parser();
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
