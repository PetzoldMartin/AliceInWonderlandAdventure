

import commands.*;
import de.fh_zwickau.oose.zuul.CommandWordsTest;
import de.fh_zwickau.oose.zuul.GameTest;
import de.fh_zwickau.oose.zuul.ParserTest;
import de.fh_zwickau.oose.zuul.PlayerTest;
import de.fh_zwickau.oose.zuul.RoomTest;

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

		// ... weitere Testklassen hinzufügen
		return mySuite;
	}
}
