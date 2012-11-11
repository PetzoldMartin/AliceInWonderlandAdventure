package commands;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import de.fh_zwickau.oose.zuul.Player;

public class QuitCommandTest {

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
