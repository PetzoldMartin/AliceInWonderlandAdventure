package Tests;



import commands.SpeakCommand;

import Tests.commandsTests.CommandWordsTest;
import Tests.commandsTests.GoCommandTest;
import Tests.commandsTests.HelpCommandTest;
import Tests.commandsTests.LookCommandTest;
import Tests.commandsTests.NullCommandTest;
import Tests.commandsTests.QuitCommandTest;
import Tests.commandsTests.RestartCommandTest;
import Tests.commandsTests.SpeakCommandTest;
import Tests.commandsTests.TakeCommandTest;
import Tests.enumTests.GameStatusTest;
import Tests.enumTests.PlayerSizeTest;
import Tests.gameobjektTests.GameObjectTest;
import Tests.zuulTests.GameTest;
import Tests.zuulTests.ParserTest;
import Tests.zuulTests.PlayerTest;
import Tests.zuulTests.RoomTest;
import junit.framework.Test;
import junit.framework.TestSuite;



public class MainTest extends TestSuite {
//der MainTest der für das testcoverage tool

	public static Test suite() {
		TestSuite mySuite = new TestSuite("Shapes Test-Suite");
		mySuite.addTestSuite(GoCommandTest.class);
		mySuite.addTestSuite(HelpCommandTest.class);
		mySuite.addTestSuite(NullCommandTest.class);
		mySuite.addTestSuite(QuitCommandTest.class);
		mySuite.addTestSuite(RestartCommandTest.class);
		mySuite.addTestSuite(CommandWordsTest.class);
		mySuite.addTestSuite(GameTest.class);
		mySuite.addTestSuite(ParserTest.class);
		mySuite.addTestSuite(PlayerTest.class);
		mySuite.addTestSuite(RoomTest.class);
		mySuite.addTestSuite(GameObjectTest.class);
		mySuite.addTestSuite(GameStatusTest.class);
		mySuite.addTestSuite(PlayerSizeTest.class);
		mySuite.addTestSuite(TakeCommandTest.class);
		mySuite.addTestSuite(LookCommandTest.class);
		mySuite.addTestSuite(SpeakCommandTest.class);
		// ... weitere Testklassen hinzufügen
		//FIXME Commandwords Test!!!
		return mySuite;
	}
}
