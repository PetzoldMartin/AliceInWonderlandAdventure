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

import executeAble.commands.UseCommand;


public class UseCommandTest  extends TestCase{

	UseCommand command;
	Player player;
	Parser parser;
	private Game game;
	
	@Before
	public void setUp() throws Exception{
		command = new UseCommand();
		parser = new Parser();
		game = new Game();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
//		Assert.assertEquals(GameStatus.RUN, command.execute(player));
//		Assert.assertEquals(GameStatus.RUN, command.execute(null));
		Assert.assertEquals(game.getParser().getCommand("nutz Lilie Rose").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals(game.getParser().getCommand("nutz flower").execute(game.getPlayer()),GameStatus.RUN);
		
	}

	@Test
	public void testShowSpecialHelp() {
		Assert.assertEquals(game.getParser().getCommand("? nutz").execute(game.getPlayer()),GameStatus.RUN);
	}

}
