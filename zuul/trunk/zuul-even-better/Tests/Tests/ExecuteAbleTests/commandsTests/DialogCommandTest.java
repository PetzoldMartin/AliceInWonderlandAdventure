package Tests.ExecuteAbleTests.commandsTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;

import executeAble.commands.DialogCommand;

public class DialogCommandTest {

	private DialogCommand dialogCommand1;
	private DialogCommand dialogCommand2;
	private Game game;

	@Before
	public void setUp() throws Exception {
		dialogCommand1= new DialogCommand("test1");
		dialogCommand2= new DialogCommand("test21","test22");
		game= new Game();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		dialogCommand1.execute(game.getPlayer());
		assertTrue(game.getTextOut().AusgabeVorhanden("test1"));
		assertTrue(game.getTextOut().AusgabeVorhanden("Deine Antwort möglichkeiten sind"));
		assertTrue(game.getTextOut().AusgabeVorhanden("1"+" :  "+ "Auf wiedersehen"));
		assertTrue(game.getTextOut().AusgabeVorhanden("? :  "+ "Hilfe"));
		game.getTextOut().clearTextOut();
		dialogCommand2.execute(game.getPlayer());
		assertTrue(game.getTextOut().AusgabeVorhanden("test22"));
		assertTrue(game.getTextOut().AusgabeVorhanden("Deine Antwort möglichkeiten sind"));
		assertTrue(game.getTextOut().AusgabeVorhanden("1"+" :  "+ "Auf wiedersehen"));
		assertTrue(game.getTextOut().AusgabeVorhanden("? :  "+ "Hilfe"));
		game.getTextOut().clearTextOut();

	}

	@Test
	public void testShowSpecialHelp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDialogCommandString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDialogCommandStringString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTextout() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testInsertDialog() {
		fail("Not yet implemented"); // TODO
	}

}
