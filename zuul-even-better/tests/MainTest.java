

import commands.*;

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

		// ... weitere Testklassen hinzufügen
		return mySuite;
	}
}
