package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.thingsWithstore.Player;
import executeAble.commands.QuitCommand;
import gameEnums.GameStatus;


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
		command.showSpecialHelp();
		assertTrue(game.getTextOut().AusgabeVorhanden("Mithilfe dieses Befehls Beendest du das Spiel."));
	}

	@Test
	public void testQuitCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
