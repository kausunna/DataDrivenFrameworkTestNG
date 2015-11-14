package com.selenium.suiteB;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.config.Constants;
import com.selenium.util.TestUtil;

public class TestCase_B2 extends TestSuiteBase {
	
	String runmode[] = null;
	static int count = -1;

	@BeforeTest
	public void checkTestSkip() {

		APP_LOGS.debug("Checking RunMode of -- "
				+ this.getClass().getSimpleName());
		if (!TestUtil.isTestCaseRunnable(suiteBxls, this.getClass()
				.getSimpleName())) {

			APP_LOGS.debug("Skipping Test Case "
					+ this.getClass().getSimpleName()
					+ " as Runmode is set to NO");
			throw new SkipException("Skipping Test Case "
					+ this.getClass().getSimpleName()
					+ " as Runmode is set to NO");
		}
		
		// Load the runmode of the testData
		runmode = TestUtil.getDataSetRunmodes(suiteAxls, this.getClass()
				.getSimpleName());

	}

	@Test(dataProvider = "getTestData")
	public void testCaseB2() {
		APP_LOGS.debug("Executing Test -- " + this.getClass().getSimpleName());
		//APP_LOGS.debug(col1 + " " + col2 + " " + col3);
		
		// Check the runmode of Data Set
		count++;
		if (!runmode[count].equalsIgnoreCase(Constants.RUNMODE_YES)) {
			throw new SkipException("Runmode of Test Data is set to NO "
					+ count);
		}

	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(suiteBxls, this.getClass().getSimpleName());

	}

}
