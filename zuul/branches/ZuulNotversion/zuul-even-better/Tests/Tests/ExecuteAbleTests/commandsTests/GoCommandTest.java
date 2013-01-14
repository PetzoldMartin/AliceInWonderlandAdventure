package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.thingsWithstore.Player;
import zuulCore.thingsWithstore.Room;
import executeAble.commands.GoCommand;
import gameEnums.GameStatus;


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
		//
		Room raum=game.getPlayer().getCurrentRoom();
		assertEquals(game.getParser().getCommand("geh norden").execute(game.getPlayer()),GameStatus.RUN);
		assertFalse(raum.equals( game.getPlayer().getCurrentRoom()));
		assertEquals(""+"Du bist in einer Höhle in der nähe des Brunnens."+"\n"+"Ausgänge: sueden", game.getPlayer().getCurrentRoom().getLongDescription());
		assertTrue(game.getTextOut().AusgabeVorhanden(""+"Du bist in einer Höhle in der nähe des Brunnens."+"\n"+"Ausgänge: sueden"));
		game.getTextOut().clearTextOut();
		//
		assertEquals(game.getParser().getCommand("geh sueden").execute(game.getPlayer()),GameStatus.RUN);
		assertEquals(raum, game.getPlayer().getCurrentRoom());
		assertEquals(""+"Du befindest dich in einem Brunnen"+"\n"+"Ausgänge: osten norden westen sueden", game.getPlayer().getCurrentRoom().getLongDescription());
		assertTrue(game.getTextOut().AusgabeVorhanden(""+"Du befindest dich in einem Brunnen"+"\n"+"Ausgänge: osten norden westen sueden"));
		game.getTextOut().clearTextOut();
	}

	@Test
	public void testShowSpecialHelp() {
		command.showSpecialHelp();
		assertTrue(game.getTextOut().AusgabeVorhanden("Es dient dazu dich im Wunderland zu bewegen."));
		game.getTextOut().clearTextOut();
	}

	@Test
	public void testGoCommand() {
		//Vorraussetzung: Get und Set -Methoden von Command funktionieren
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertEquals(command.getSecondWord(),"Testwort");
	}

}
