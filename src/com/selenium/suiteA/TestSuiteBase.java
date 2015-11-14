package com.selenium.suiteA;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.selenium.base.TestBase;
import com.selenium.util.TestUtil;
import com.selenium.config.*;

public class TestSuiteBase extends TestBase {

	// Check the Suite RunMode
	@BeforeSuite
	public void checkSuiteSkip() throws Exception  {

		initialize();
		APP_LOGS.debug("Checking the RunMode of Suite A");
		if (!TestUtil.isSuiteRunnable(suiteXls, Constants.SUITE_A)) {
			APP_LOGS.debug("Skip suite A as Runmode is set to NO");
			throw new SkipException(
					"Rumode of Suite A is No. Skipping the suite");

		}

	}

}
