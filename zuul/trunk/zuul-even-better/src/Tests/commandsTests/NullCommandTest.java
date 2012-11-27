package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import commands.NullCommand;

import de.fh_zwickau.oose.zuul.Game;
import de.fh_zwickau.oose.zuul.Player;

public class NullCommandTest extends TestCase{

	NullCommand command;
	Player player;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new NullCommand();
		game= new Game();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
	}

	@Test
	public void testShowSpecialHelp() {
		//Nicht Testbar
	}

	@Test
	public void testNullCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
