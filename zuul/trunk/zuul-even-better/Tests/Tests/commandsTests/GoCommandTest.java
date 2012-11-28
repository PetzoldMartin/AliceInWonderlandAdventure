package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Player;
import zuulCore.Room;

import GamePlayEnums.GameStatus;

import commands.GoCommand;


public class GoCommandTest extends TestCase {

	GoCommand command;
	Player player;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new GoCommand();
		player=new Player();
		game= new Game();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
		//
		Room raum=game.getPlayer().getCurrentRoom();
		game.getParser().getCommand("geh norden").execute(game.getPlayer());
		assertFalse(raum.equals( game.getPlayer().getCurrentRoom()));
		//
		game.getParser().getCommand("geh sueden").execute(game.getPlayer());
		assertEquals(raum, game.getPlayer().getCurrentRoom());
	}

	@Test
	public void testShowSpecialHelp() {
		assertEquals(game.getParser().getCommand("? geh").execute(player),GameStatus.RUN);
		assertEquals(game.getParser().getCommand("? geh").getSecondWord(), "geh");
	}

	@Test
	public void testGoCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertEquals(command.getSecondWord(),"Testwort");
	}

}
