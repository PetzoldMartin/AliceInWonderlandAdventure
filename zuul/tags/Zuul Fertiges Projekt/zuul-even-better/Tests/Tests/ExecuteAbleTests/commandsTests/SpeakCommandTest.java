package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Parser;
import zuulCore.thingsWithstore.Player;
import executeAble.commands.SpeakCommand;
import gameEnums.GameStatus;


public class SpeakCommandTest  extends TestCase{

	SpeakCommand command;
	Player player;
	Parser parser;
	private Game game;
	
	@Before
	public void setUp() throws Exception{
		command = new SpeakCommand();
		game = new Game();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
		game.getTextOut().clearTextOut();
		Assert.assertEquals(game.getParser().getCommand("sprich dass").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("So verrückt bin ich nun auch wieder nicht."));
		game.getTextOut().clearTextOut();
		Assert.assertEquals(game.getParser().getCommand("sprich flower").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("So verrückt bin ich nun auch wieder nicht."));
		game.getTextOut().clearTextOut();
		Assert.assertEquals(game.getParser().getCommand("sprich Holz").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("So verrückt bin ich nun auch wieder nicht."));
		game.getTextOut().clearTextOut();
		Assert.assertEquals(game.getParser().getCommand("sprich Kaninchen").execute(game.getPlayer()),GameStatus.RUN);
		
	}

	@Test
	public void testShowSpecialHelp() {
		command.showSpecialHelp();
		game.getTextOut().AusgabeVorhanden("Du versuchst mit etwas oder jemand zu sprechen.");
	}

}
