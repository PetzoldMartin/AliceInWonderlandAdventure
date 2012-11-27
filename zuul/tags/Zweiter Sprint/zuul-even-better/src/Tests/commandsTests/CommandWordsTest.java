package Tests.commandsTests;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import de.fh_zwickau.oose.zuul.CommandWords;
import de.fh_zwickau.oose.zuul.Game;



public class CommandWordsTest extends TestCase{
	
	CommandWords cWT;
	private Game game;

	@Before
	public void setUp() throws Exception {
		cWT = new CommandWords();
		game= new Game();
	}

	@Test
	public void testCommandWords() {
		Assert.assertNotNull(cWT);
	}

	@Test
	public void testShowAll() {
		//Weitere "nurTextausgabe
		}

	@Test
	public void testShowspecialhelp() {
		//Textausgabe
	}

}
