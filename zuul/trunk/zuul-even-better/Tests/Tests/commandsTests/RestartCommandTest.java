package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

import executeAble.commands.RestartCommand;


public class RestartCommandTest extends TestCase{

	RestartCommand command;
	Player player;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new RestartCommand();
		game= new Game();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RESTART, command.execute(player));
		Assert.assertEquals(GameStatus.RESTART, command.execute(null));
		command.setSecondWord("testword");
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
	}

	@Test
	public void testShowSpecialHelp() {
		assertEquals(game.getParser().getCommand("? neustart").execute(player),GameStatus.RUN);
		assertEquals(game.getParser().getCommand("? neustart").getSecondWord(), "neustart");
	}

	@Test
	public void testRestartCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
