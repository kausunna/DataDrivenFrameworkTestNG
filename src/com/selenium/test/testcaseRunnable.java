package com.selenium.test;

import com.selenium.config.Constants;
import com.selenium.util.Xls_Reader;

public class testcaseRunnable {

	public static void main(String[] args) {

		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")
				+ "\\src\\com\\selenium\\xls\\" + Constants.TEST_CASE_A);
		
		Xls_Reader xl2 = new Xls_Reader(System.getProperty("user.dir")
				+ "\\src\\com\\selenium\\xls\\" + Constants.TEST_CASE_A);
		

		System.out.println(isTestCaseRunnable(xl, "LoginTest"));
		 System.out.println(isTestCaseRunnable(xl, "SearchTest"));
		 
		
		// System.out.println(isTestCaseRunnable(xl, "C Suite"));

	}

	// CHECK IF THE RUNMODE OF TEST CASE UNDER TESTCASE SHEET SHEET IS YES
	// OR NO
	public static boolean isTestCaseRunnable(Xls_Reader xls, String testcaseName) {

		boolean isExecutable = false;

		for (int i = 2; i <= xls.getRowCount(Constants.TEST_CASE_SHEET); i++) {
			// PRINT TSID

/*			System.out.println(xls.getCellData(Constants.TEST_CASE_SHEET,
					Constants.TEST_CASE_ID, i)); // PRINT RUNMODE OF SUITE
			System.out.println(xls.getCellData(Constants.TEST_CASE_SHEET,
					Constants.RUNMODE, i));*/

			String suite = xls.getCellData(Constants.TEST_CASE_SHEET,
					Constants.TEST_CASE_ID, i);

			String suiteRunMode = xls.getCellData(Constants.TEST_CASE_SHEET,
					Constants.RUNMODE, i);

			if (suite.equalsIgnoreCase(testcaseName)) {

				if (suiteRunMode.equalsIgnoreCase(Constants.RUNMODE_YES)) {

					isExecutable = true;
				} else {
					isExecutable = false;
				}
			}

		}

		xls = null; // TO RELEASE MEMORY
		return isExecutable;

	}

}
