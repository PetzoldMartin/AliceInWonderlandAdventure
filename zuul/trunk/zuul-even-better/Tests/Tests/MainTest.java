package Tests;



import junit.framework.Test;
import junit.framework.TestSuite;
import Tests.ExecuteAbleTests.ExecuteAbleTest;
import Tests.ExecuteAbleTests.commandsTests.DialogCommandTest;
import Tests.ExecuteAbleTests.commandsTests.DialogEndCommandTest;
import Tests.ExecuteAbleTests.commandsTests.GoCommandTest;
import Tests.ExecuteAbleTests.commandsTests.HelpCommandTest;
import Tests.ExecuteAbleTests.commandsTests.LookCommandTest;
import Tests.ExecuteAbleTests.commandsTests.NullCommandTest;
import Tests.ExecuteAbleTests.commandsTests.QuitCommandTest;
import Tests.ExecuteAbleTests.commandsTests.RestartCommandTest;
import Tests.ExecuteAbleTests.commandsTests.SpeakCommandTest;
import Tests.ExecuteAbleTests.commandsTests.TakeCommandTest;
import Tests.ExecuteAbleTests.commandsTests.UseCommandTest;
import Tests.gameBuildingTest.CommandWordsTest;
import Tests.gameEnumTests.GameStatusTest;
import Tests.gameEnumTests.PlayerSizeTest;
import Tests.gameobjektTests.GameObjectTest;
import Tests.zuulTests.GameTest;
import Tests.zuulTests.ParserTest;
import Tests.zuulTests.PlayerTest;
import Tests.zuulTests.RoomTest;
import Tests.zuulTests.TextOutTest;



public class MainTest extends TestSuite {
//der MainTest der für das testcoverage tool

	public static Test suite() {
		TestSuite mySuite = new TestSuite("Shapes Test-Suite");
		mySuite.addTestSuite(TextOutTest.class);
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
		mySuite.addTestSuite(UseCommandTest.class);
		mySuite.addTestSuite(DialogCommandTest.class);
		mySuite.addTestSuite(ExecuteAbleTest.class);
		mySuite.addTestSuite(DialogEndCommandTest.class);
		return mySuite;
	}
}
