package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.thingsWithstore.Player;
import executeAble.commands.RestartCommand;


public class RestartCommandTest extends TestCase{

	RestartCommand command;
	Player player;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new RestartCommand();
		game= new Game();
	}

	@Test
	public void testExecute() {
		command.execute(game.getPlayer());
		assertTrue(game.getTextOut().AusgabeVorhanden("Das Wunderland wird neu Geträumt... "));
		assertTrue(game.getTextOut().AusgabeVorhanden("Was getan war ist nun nie Geschehn... "));
		assertTrue(game.getTextOut().AusgabeVorhanden("Der Hutmacher hat noch alle Tassen im Schrank... "));
		assertTrue(game.getTextOut().AusgabeVorhanden("... "));
		game.getTextOut().clearTextOut();
		command.setSecondWord("test");
		command.execute(null);
		assertTrue(game.getTextOut().AusgabeVorhanden("Ich kann das nicht neu starten..."));
	}

	@Test
	public void testShowSpecialHelp() {
		command.showSpecialHelp();
		assertTrue(game.getTextOut().AusgabeVorhanden("Mit diesen Befehl würd das Aktuelle Spiel neu gestartet. Alle Gegenstände verschwinden aus dem Inventar."));
	}

	@Test
	public void testRestartCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
	}

}
