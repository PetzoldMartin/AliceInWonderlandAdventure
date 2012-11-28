package Tests.zuulTests;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zuulCore.TextOut;


public class TextOutTest extends TestCase{

	private TextOut textout;

	@Before
	public void setUp() throws Exception {
		textout=new TextOut();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTextOut() {
		assertNotNull(textout);
	}

	@Test
	public void testAusgabe() {
		textout.lineEntry("test");
		textout.entry("test");
		assertEquals("test",textout.getTextZeile());
		assertTrue(textout.AusgabeVorhanden("test"));
		textout.ausgabe();
		assertFalse("test".equals(textout.getTextZeile()));
		assertFalse(textout.AusgabeVorhanden("test"));
	}

	@Test
	public void testLineEntryString() {
		textout.lineEntry("test");
		assertTrue(textout.AusgabeVorhanden("test"));
		assertFalse(textout.AusgabeVorhanden("nichttest"));
	}

	@Test
	public void testLineEntry() {
		textout.lineEntry();
		assertTrue(textout.AusgabeVorhanden(""));
		assertFalse(textout.AusgabeVorhanden("nichttest"));
	}

	@Test
	public void testEntry() {
		textout.entry("test");
		assertEquals("test",textout.getTextZeile());
		assertFalse("nichttest".equals(textout.getTextZeile()));
	}

	@Test
	public void testAusgabeVorhanden() {
		assertFalse(textout.AusgabeVorhanden("test"));
		textout.lineEntry("test");
		assertTrue(textout.AusgabeVorhanden("test"));
		assertFalse(textout.AusgabeVorhanden("nichttest"));
	}


}
