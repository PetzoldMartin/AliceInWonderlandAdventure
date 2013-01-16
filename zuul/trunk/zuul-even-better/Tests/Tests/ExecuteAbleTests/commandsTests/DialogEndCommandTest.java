package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import executeAble.commands.DialogEndCommand;
import gameEnums.GameStatus;

public class DialogEndCommandTest extends TestCase{

	private DialogEndCommand dialogEndCommand;
	private Game game;

	@Before
	public void setUp() throws Exception {
		dialogEndCommand= new DialogEndCommand();
		game=new Game();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		assertEquals(dialogEndCommand.execute(game.getPlayer()),GameStatus.RUN);
		assertTrue(game.getTextOut().AusgabeVorhanden("Du hast das Gespräch beendet"));
		assertTrue(game.getTextOut().AusgabeVorhanden(""+"Du befindest dich in einem Brunnen"+"\n"+"Ausgänge: osten norden westen sueden"));
		game.getTextOut().clearTextOut();
		game.getPlayer().getnCW().showAll();
		assertEquals(game.getTextOut().getTextZeile(), "?  ende  geh  guck  hilfe  neustart  nimm  nutz  sprich  ");
		game.getTextOut().clearTextOut();
	}

	@Test
	public void testShowSpecialHelp() {
		dialogEndCommand.showSpecialHelp();
		assertTrue(game.getTextOut().AusgabeVorhanden("Das Kommando was das Gespräch beendet"));
	}

	@Test
	public void testDialogEndCommand() {
		assertNotNull(dialogEndCommand);
	}

}
