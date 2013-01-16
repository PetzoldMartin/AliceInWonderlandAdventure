package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Parser;
import zuulCore.thingsWithstore.Player;
import executeAble.commands.TakeCommand;
import gameEnums.GameStatus;


public class TakeCommandTest  extends TestCase{

	TakeCommand command;
	Player player;
	Parser parser;
	private Game game;
	
	@Before
	public void setUp() throws Exception{
		command = new TakeCommand();
		game = new Game();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
		Assert.assertEquals("", game.getPlayer().getAllItemsToString());
		Assert.assertEquals(game.getParser().getCommand("nimm dass").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals("", game.getPlayer().getAllItemsToString());
		Assert.assertEquals(game.getParser().getCommand("nimm Rose").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals("", game.getPlayer().getAllItemsToString());
		game.getParser().getCommand("geh norden").execute(game.getPlayer());
		Assert.assertEquals(game.getParser().getCommand("nimm Harfe").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals("Harfe ", game.getPlayer().getAllItemsToString());
		Assert.assertEquals(game.getParser().getCommand("nimm Holz").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals("Harfe ", game.getPlayer().getAllItemsToString());
	}

	@Test
	public void testShowSpecialHelp() {
		Assert.assertEquals(game.getParser().getCommand("? nimm").execute(game.getPlayer()),GameStatus.RUN);
	}

}
