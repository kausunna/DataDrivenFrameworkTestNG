package com.selenium.test;

import com.selenium.util.Xls_Reader;
import com.selenium.config.*;

public class SuiteRunnable {

	public static void main(String[] args) {

		// CREATE AN OBJECT OF XLS_READER CLASS AND PASS THE PATH OF XLS
		// FILE(SUITE.XLSX)
		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")
				+ "\\src\\com\\selenium\\xls\\" + Constants.TEST_SUITE);

		System.out.println(isSuiteRunnable(xl, "A Suite"));
		System.out.println(isSuiteRunnable(xl, "B Suite"));
		System.out.println(isSuiteRunnable(xl, "C Suite"));

	}

	// CHECK IF THE RUNMODE OF SUITE UNDER "SUITE.XLSX->Test Suite" SHEET IS YES
	// OR NO
	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName) {

		boolean isExecutable = false;

		for (int i = 2; i <= xls.getRowCount(Constants.TEST_SUITE_SHEET); i++) {
			// PRINT TSID
			/*
			 * System.out.println(xls.getCellData(Constants.TEST_SUITE_SHEET,
			 * Constants.TEST_SUITE_ID, i)); // PRINT RUNMODE OF SUITE
			 * System.out.println(xls.getCellData(Constants.TEST_SUITE_SHEET,
			 * Constants.TEST_SUITE_RUNMODE, i));
			 */
			String suite = xls.getCellData(Constants.TEST_SUITE_SHEET,
					Constants.TEST_SUITE_ID, i);

			String suiteRunMode = xls.getCellData(Constants.TEST_SUITE_SHEET,
					Constants.RUNMODE, i);

			if (suite.equalsIgnoreCase(suiteName)) {

				if (suiteRunMode
						.equalsIgnoreCase(Constants.RUNMODE_YES)) {

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
