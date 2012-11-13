package de.fh_zwickau.oose.zuul;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CommandWordsTest {
	
	CommandWords cWT;

	@Before
	public void setUp() throws Exception {
		cWT = new CommandWords();
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
