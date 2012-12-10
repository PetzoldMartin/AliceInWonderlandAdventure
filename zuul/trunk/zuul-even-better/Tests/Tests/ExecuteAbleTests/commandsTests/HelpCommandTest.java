package Tests.ExecuteAbleTests.commandsTests;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zuulCore.Game;
import zuulCore.Parser;
import zuulCore.Player;
import executeAble.commands.HelpCommand;
import gameBuilding.CommandWords;
import gameEnums.GameStatus;


public class HelpCommandTest extends TestCase{

	HelpCommand command;
	Player player;
	Parser parser;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		command = new HelpCommand(new CommandWords());
		game= new Game();
	}

	@Test
	public void testExecute() {
		Assert.assertEquals(GameStatus.RUN, command.execute(player));
		Assert.assertEquals(GameStatus.RUN, command.execute(null));
	}

	@Test
	public void testShowSpecialHelp() {
		game.getParser().getCommand("? ?").execute(game.getPlayer());
		assertTrue(game.getTextOut().AusgabeVorhanden("Dies ist das Kommando für die Hilfe wie du schon herausgefunden hast."));
		assertEquals(game.getParser().getCommand("? ?").getSecondWord(),"?");
		assertEquals(game.getParser().getCommand("? ?").execute(player), GameStatus.RUN);
		assertEquals(game.getParser().getCommand("? blabla").execute(player), GameStatus.RUN);
	}

	@Test
	public void testHelpCommand() {
		Assert.assertNull(command.getSecondWord());
		command.setSecondWord("Testwort");
		Assert.assertNotNull(command.getSecondWord());
		game.getParser().getCommand("?").execute(game.getPlayer());
		assertTrue(game.getTextOut().AusgabeVorhanden("Ja, wo ist denn das Kaninchen hin?"));
		assertTrue(game.getTextOut().AusgabeVorhanden("Du scheinst es aus den Augen verloren zu haben."));
		assertTrue(game.getTextOut().AusgabeVorhanden("Versuche es wieder zu finden!"));
		assertTrue(game.getTextOut().AusgabeVorhanden("deine Befehlswörter sind:"));
		assertEquals(game.getTextOut().getTextZeile(),"ende  nutz  hilfe  sprich  geh  neustart  nimm  guck  ?  ");
		game.getTextOut().clearTextOut();
		
	}

}
