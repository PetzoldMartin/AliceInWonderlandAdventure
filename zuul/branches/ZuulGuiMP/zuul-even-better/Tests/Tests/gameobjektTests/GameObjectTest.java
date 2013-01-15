package Tests.gameobjektTests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zuulCore.GameObject;


public class GameObjectTest extends TestCase{

	private GameObject toTest;
	private GameObject toTest2;

	@Before
	public void setUp() throws Exception {
		toTest = new GameObject();
		toTest2 = new GameObject("Testobjekt","beschreibung", true, true, false);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGameObject() {
		toTest=new GameObject();
		assertNotNull(toTest);
	}

	@Test
	public void testGameObjectStringStringBooleanBooleanBoolean() {
		toTest2 = new GameObject("Testobjekt","beschreibung", true, true, false);
		assertNotNull(toTest2);
	}

	@Test
	public void testGetObjName() {
		assertEquals(toTest.getObjName(), "-!-default-!-");
		assertEquals(toTest2.getObjName(), "Testobjekt");
		
	}

	@Test
	public void testSetObjName() {
		toTest2.setObjName("änderung");
		assertEquals(toTest2.getObjName(), "änderung");
	}

	@Test
	public void testGetAmplification() {
		assertEquals(toTest.getAmplification(), "-!-default-!-");
		assertEquals(toTest2.getAmplification(), "beschreibung");
	}

	@Test
	public void testSetAmplification() {
		toTest2.setAmplification("änderung");
		assertEquals(toTest2.getAmplification(), "änderung");
	}

	@Test
	public void testIsTakeAble() {
		assertEquals(toTest.isTakeAble(),false);
		assertEquals(toTest2.isTakeAble(), true);
	}

	@Test
	public void testSetTakeAble() {
		toTest2.setTakeAble(false);
		assertEquals(toTest2.isTakeAble(), false);
	}

	@Test
	public void testIsSpeakAble() {
		assertEquals(toTest.isSpeakAble(),false);
		assertEquals(toTest2.isSpeakAble(), true);
	}

	@Test
	public void testSetSpeakAble() {
		toTest2.setSpeakAble(false);
		assertEquals(toTest2.isSpeakAble(), false);
	}

	@Test
	public void testIsVisebility() {
		assertEquals(toTest.isVisebility(),true);
		assertEquals(toTest2.isVisebility(), false);
	}

	@Test
	public void testSetVisebility() {
		toTest2.setVisebility(true);
		assertEquals(toTest2.isVisebility(), true);
	}

}
