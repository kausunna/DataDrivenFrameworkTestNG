package com.selenium.suiteB;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.selenium.base.TestBase;
import com.selenium.config.Constants;
import com.selenium.util.TestUtil;

public class TestSuiteBase extends TestBase {

	// Check the Suite RunMode
	@BeforeSuite
	public void checkSuiteSkip() throws Exception {

		initialize();
		APP_LOGS.debug("Checking the RunMode of Suite B");
		if (!TestUtil.isSuiteRunnable(suiteXls, Constants.SUITE_B)) {
			APP_LOGS.debug("Skip suite B as Runmode is set to NO");
			throw new SkipException(
					"Rumode of Suite B is No. Skipping the suite");

		}

	}

}
