package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import commands.RestartCommand;

import de.fh_zwickau.oose.zuul.Game;
import de.fh_zwickau.oose.zuul.Player;

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
