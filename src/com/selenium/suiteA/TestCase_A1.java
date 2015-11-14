package com.selenium.suiteA;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.config.Constants;
import com.selenium.util.ErrorUtil;
import com.selenium.util.TestUtil;

public class TestCase_A1 extends TestSuiteBase {

	String runmode[] = null;
	static int count = -1;
	static boolean fail = false;
	static boolean pass = false;
	static boolean skip = false;
	static boolean isTestPass = true;

	@BeforeTest
	public void checkTestSkip() {

		APP_LOGS.debug("Checking RunMode of -- "
				+ this.getClass().getSimpleName());
		if (!TestUtil.isTestCaseRunnable(suiteAxls, this.getClass()
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
	public void testCaseA1(String col1, String col2, String col3, String col4) {
		APP_LOGS.debug("Executing Test -- " + this.getClass().getSimpleName());
		APP_LOGS.debug(col1 + " " + col2 + " " + col3 + " " + col4);

		// Check the runmode of Data Set
		count++;
		if (!runmode[count].equalsIgnoreCase(Constants.RUNMODE_YES)) {
			skip = true;
			throw new SkipException("Runmode of Test Data is set to NO "
					+ count);
		}
	
			// Assertions - WebDriver code will come here
			String expected_str = "xyz";
			String actual_str = "xyz";
	
			try {
				Assert.assertEquals(expected_str, actual_str);
			} catch (Throwable e) {
	
				fail = true;
				isTestPass = false;
	
				// code to report error in TestNG
				ErrorUtil.addVerificationFailure(e);
	
				// report error in XLs
				TestUtil.updateResult(suiteAxls, this.getClass().getSimpleName(),
						count + 2, Constants.TEST_FAIL);
				// return; --> if dont want to continue with the current test case,
				// uncomment return
			}

		// System.out.println("********************");
	}

	@AfterMethod()
	public void reportDataSetResult() {
		if (skip) {
			TestUtil.updateResult(suiteAxls, this.getClass().getSimpleName(),
					count + 2, Constants.TEST_SKIP);
		} else if (fail) {
			TestUtil.updateResult(suiteAxls, this.getClass().getSimpleName(),
					count + 2, Constants.TEST_FAIL);
		} else {
			TestUtil.updateResult(suiteAxls, this.getClass().getSimpleName(),
					count + 2, Constants.TEST_PASS);
		}

		skip = false;
		fail = false;

	}

	// TO REPORT PASS/FAIL IN TEST CASE SHEET
	@AfterTest
	public void reportTestResult() {
		if (isTestPass) {
			TestUtil.updateResult(suiteAxls, Constants.TEST_CASE_SHEET,
					TestUtil.getRowNum(suiteAxls, this.getClass()
							.getSimpleName()), Constants.TEST_PASS);
		} else {
			TestUtil.updateResult(suiteAxls, Constants.TEST_CASE_SHEET,
					TestUtil.getRowNum(suiteAxls, this.getClass()
							.getSimpleName()), Constants.TEST_FAIL);

		}

	}

	// TO PARAMETERIZE THE TEST CASES
	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(suiteAxls, this.getClass().getSimpleName());

	}

}
