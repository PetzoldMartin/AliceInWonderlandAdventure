package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;

import executeAble.commands.DialogCommand;

public class DialogCommandTest extends TestCase {

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
	public void testDialogCommandString() {
		assertNotNull(dialogCommand1);
	}
	
	@Test
	public void testDialogCommandStringString() {
		assertNotNull(dialogCommand2);
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
		dialogCommand1.showSpecialHelp();
		assertTrue(game.getTextOut().AusgabeVorhanden("damit kannst du "+"Gesprächsanfang" + " sagen"));
		game.getTextOut().clearTextOut();
		dialogCommand2.showSpecialHelp();
		assertTrue(game.getTextOut().AusgabeVorhanden("damit kannst du "+"test21" + " sagen"));
	}


	@Test
	public void testGetTextout() {
		assertEquals(dialogCommand1.getTextout(),"Gesprächsanfang");
	}

	@Test
	public void testInsertDialog() {
		assertEquals(dialogCommand2.getTextout(),"test21");
	}

}
