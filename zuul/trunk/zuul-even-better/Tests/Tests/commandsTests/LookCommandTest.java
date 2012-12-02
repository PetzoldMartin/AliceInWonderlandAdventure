package Tests.commandsTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Parser;
import zuulCore.Player;
import gameEnums.GameStatus;
import executeAble.commands.LookCommand;


public class LookCommandTest  extends TestCase{

	LookCommand command;
	Player player;
	Parser parser;
	private Game game;
	
	@Before
	public void setUp() throws Exception{
		command = new LookCommand();
		parser = new Parser();
		game = new Game();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		//Look anfrage ohne secondword
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		assertTrue(game.getTextOut().AusgabeVorhanden("Was soll ich den Betrachten?"));
		game.getTextOut().ausgabe();
		assertFalse(game.getTextOut().AusgabeVorhanden("Was soll ich den Betrachten?"));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
		assertTrue(game.getTextOut().AusgabeVorhanden("Was soll ich den Betrachten?"));
		
		//Einen nicht vorhanden Gegenstand anschauen
		Assert.assertEquals(game.getParser().getCommand("guck dass").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("Gegenstand ist nicht vorhanden."));
		game.getTextOut().ausgabe();
		assertFalse(game.getTextOut().AusgabeVorhanden("Gegenstand ist nicht vorhanden."));
		
		//einen Aufnehmbaren Gegenstand anschauen
		Assert.assertEquals(game.getParser().getCommand("guck Lilie").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("blumen blumen"));
		
		//einen Nicht Aufnehmbaren Gegenstand Anschauen
		Assert.assertEquals(game.getParser().getCommand("guck Rose").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("blumen blumen blumen die nicht ansprechen kannst und nicht aufnehmen"));
		
		//einen nicht sichtbaren Gegnstand Anschauen
		Assert.assertEquals(game.getParser().getCommand("guck Holz").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("Gegenstand ist nicht vorhanden."));
		
		//in das Leere Inventar schauen
		Assert.assertEquals(game.getParser().getCommand("guck inventar").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("Ich habe kein Inventar"));
		game.getTextOut().ausgabe();
		
		//im Raum umschauen
		Assert.assertEquals(game.getParser().getCommand("guck room").execute(game.getPlayer()),GameStatus.RUN);
		assertEquals(game.getTextOut().getTextZeile(),("Im Raum erkennst du: Lilie, Rose, Kaninchen."));
		game.getTextOut().ausgabe();
		
		//ein gefülltes Inventar anschauen
		Assert.assertEquals(game.getParser().getCommand("nimm Lilie").execute(game.getPlayer()),GameStatus.RUN);
		Assert.assertEquals(game.getParser().getCommand("guck inventar").execute(game.getPlayer()),GameStatus.RUN);
		assertEquals(game.getTextOut().getTextZeile(),("In dein Inventar befindet sich: Lilie."));
		
	}

	@Test
	public void testShowSpecialHelp() {
		Assert.assertEquals(game.getParser().getCommand("? guck").execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("Nutze Guck um Gegenstände genauer zu betrachten! "));
		assertTrue(game.getTextOut().AusgabeVorhanden("Um dein Inventar anzuschaun nutz >Guck inventar< !"));
		assertTrue(game.getTextOut().AusgabeVorhanden("Um dein Raum anzuschaun nutz >Guck room< !"));
		
	}

}
