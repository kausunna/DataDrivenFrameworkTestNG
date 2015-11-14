package com.selenium.suiteC;

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
		APP_LOGS.debug("Checking the RunMode of Suite C");
		if (!TestUtil.isSuiteRunnable(suiteXls, Constants.SUITE_C)) {
			APP_LOGS.debug("Skip suite C as Runmode is set to NO");
			throw new SkipException(
					"Rumode of Suite C is No. Skipping the suite");

		}

	}

}
