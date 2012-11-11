package commands;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import de.fh_zwickau.oose.zuul.CommandWords;
import de.fh_zwickau.oose.zuul.Player;

public class HelpCommandTest {

	HelpCommand command;
	Player player;
	
	@Before
	public void setUp() throws Exception {
		command = new HelpCommand(new CommandWords());
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
	public void testHelpCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
