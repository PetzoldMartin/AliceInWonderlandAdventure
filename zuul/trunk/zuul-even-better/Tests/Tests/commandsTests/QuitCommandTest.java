package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Player;

import GamePlayEnums.GameStatus;

import commands.QuitCommand;


public class QuitCommandTest extends TestCase{

	QuitCommand command;
	Player player;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new QuitCommand();
		game= new Game();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.STOP, command.execute(player));
		Assert.assertEquals(GameStatus.STOP, command.execute(null));
		command.setSecondWord("testword");
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
	}

	@Test
	public void testShowSpecialHelp() {
		assertEquals(game.getParser().getCommand("? ende").execute(player),GameStatus.RUN);
		assertEquals(game.getParser().getCommand("? ende").getSecondWord(), "ende");
		
	}

	@Test
	public void testQuitCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
