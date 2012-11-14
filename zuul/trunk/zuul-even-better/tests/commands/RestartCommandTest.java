package commands;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import de.fh_zwickau.oose.zuul.Player;

public class RestartCommandTest extends TestCase{

	RestartCommand command;
	Player player;
	
	@Before
	public void setUp() throws Exception {
		command = new RestartCommand();
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
		//Nicht Testbar
	}

	@Test
	public void testRestartCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
