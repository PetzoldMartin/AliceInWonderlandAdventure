package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Parser;
import zuulCore.Player;
import GamePlayEnums.GameStatus;
import executeAble.commands.TakeCommand;


public class TakeCommandTest  extends TestCase{

	TakeCommand command;
	Player player;
	Parser parser;
	private Game game;
	
	@Before
	public void setUp() throws Exception{
		command = new TakeCommand();
		parser = new Parser();
		game = new Game();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
		Assert.assertEquals(game.getParser().getCommand("nimm dass").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals(game.getParser().getCommand("nimm flower").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals(game.getParser().getCommand("nimm blumea").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals(game.getParser().getCommand("nimm Holz").execute(game.getPlayer()),GameStatus.RUN);
	}

	@Test
	public void testShowSpecialHelp() {
		Assert.assertEquals(game.getParser().getCommand("? nimm").execute(game.getPlayer()),GameStatus.RUN);
	}

}
