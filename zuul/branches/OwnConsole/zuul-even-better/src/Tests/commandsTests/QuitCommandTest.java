package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import commands.QuitCommand;

import de.fh_zwickau.oose.zuul.Player;

public class QuitCommandTest extends TestCase{

	QuitCommand command;
	Player player;
	
	@Before
	public void setUp() throws Exception {
		command = new QuitCommand();
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
		//Nicht Testbar
	}

	@Test
	public void testQuitCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
