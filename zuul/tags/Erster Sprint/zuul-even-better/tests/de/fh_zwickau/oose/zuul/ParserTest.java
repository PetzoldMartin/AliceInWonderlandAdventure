package de.fh_zwickau.oose.zuul;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest extends TestCase{
	Parser parser;
	private Game game;

	@Before
	public void setUp() throws Exception {
		parser = new Parser();
		game = new Game();
	}

	@Test
	public void testParser() {
		Assert.assertNotNull(parser);
	}

	@Test
	public void testShowCommands() {
		//funktioniert wen commands.showall funktioniert
	}

}
