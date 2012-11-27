package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GamePlayEnums.GameStatus;

import commands.GoCommand;

import de.fh_zwickau.oose.zuul.Game;
import de.fh_zwickau.oose.zuul.Player;

public class GoCommandTest extends TestCase {

	GoCommand command;
	Player player;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new GoCommand();
		player=new Player();
		game= new Game();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
	}

	@Test
	public void testShowSpecialHelp() {
		//Nicht Testbar(Es wird eh nur 1 Text Ausgegeben-Lösbar wenn wir string oder boolean als rückgabe wert nehmen)
	}

	@Test
	public void testGoCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
