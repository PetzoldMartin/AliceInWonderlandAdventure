package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import commands.HelpCommand;
import de.fh_zwickau.oose.zuul.CommandWords;
import de.fh_zwickau.oose.zuul.Parser;
import de.fh_zwickau.oose.zuul.Player;

import GamePlayEnums.GameStatus;

public class HelpCommandTest extends TestCase{

	HelpCommand command;
	Player player;
	Parser parser;
	
	@Before
	public void setUp() throws Exception {
		command = new HelpCommand(new CommandWords());
		parser = new Parser();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
	}

	@Test
	public void testShowSpecialHelp() {
		assertNotNull(parser.getCommand("? ?"));
		System.out.println(parser.getCommand("? ?").execute(player));
		//Nicht Testbar
	}

	@Test
	public void testHelpCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
