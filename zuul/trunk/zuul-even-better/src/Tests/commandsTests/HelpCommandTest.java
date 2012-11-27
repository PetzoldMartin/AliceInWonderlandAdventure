package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import commands.HelpCommand;

import de.fh_zwickau.oose.zuul.CommandWords;
import de.fh_zwickau.oose.zuul.Game;
import de.fh_zwickau.oose.zuul.Parser;
import de.fh_zwickau.oose.zuul.Player;

public class HelpCommandTest extends TestCase{

	HelpCommand command;
	Player player;
	Parser parser;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new HelpCommand(new CommandWords());
		parser = new Parser();
		game= new Game();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
	}

	@Test
	public void testShowSpecialHelp() {
		assertEquals(parser.getCommand("? ?").getSecondWord(),"?");
		assertEquals(parser.getCommand("? ?").execute(player), GameStatus.RUN);
		assertEquals(parser.getCommand("? blabla").execute(player), GameStatus.RUN);
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
