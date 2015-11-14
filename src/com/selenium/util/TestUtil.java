package com.selenium.util;

import com.selenium.config.Constants;

public class TestUtil {

	// CHECK IF THE RUNMODE OF SUITE UNDER "SUITE.XLSX->Test Suite" SHEET IS YES
	// OR NO
	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName) {

		boolean isExecutable = false;

		for (int i = 2; i <= xls.getRowCount(Constants.TEST_SUITE_SHEET); i++) {

			String suite = xls.getCellData(Constants.TEST_SUITE_SHEET,
					Constants.TEST_SUITE_ID, i);

			String suiteRunMode = xls.getCellData(Constants.TEST_SUITE_SHEET,
					Constants.RUNMODE, i);

			if (suite.equalsIgnoreCase(suiteName)) {

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

	// CHECK IF THE RUNMODE OF TEST CASE UNDER TESTCASE SHEET SHEET IS YES
	// OR NO
	public static boolean isTestCaseRunnable(Xls_Reader xls, String testcaseName) {

		boolean isExecutable = false;

		for (int i = 2; i <= xls.getRowCount(Constants.TEST_CASE_SHEET); i++) {

			String testcase = xls.getCellData(Constants.TEST_CASE_SHEET,
					Constants.TEST_CASE_ID, i);

			String testcaseRunMode = xls.getCellData(Constants.TEST_CASE_SHEET,
					Constants.RUNMODE, i);

			if (testcase.equalsIgnoreCase(testcaseName)) {

				if (testcaseRunMode.equalsIgnoreCase(Constants.RUNMODE_YES)) {

					isExecutable = true;
				} else {
					isExecutable = false;
				}
			}

		}

		xls = null; // TO RELEASE MEMORY
		return isExecutable;

	}

	// RETURN DATA FROM TEST DATA SHEET IF THE SHEET EXISTS IN TWO DIMESIONAL
	// ARRAY
	public static Object[][] getData(Xls_Reader xls, String testCaseName) {

		if (!xls.isSheetExist(testCaseName)) {
			return new Object[1][0];
		}

		int row = (xls.getRowCount(testCaseName));
		int col = xls.getColumnCount(testCaseName);

		System.out.println("Rows -- " + row + " || Cols -- " + col);

		Object[][] data = new Object[row - 1][col - 3];

		for (int rowNum = 2; rowNum <= row; rowNum++) {
			for (int colNum = 0; colNum < col - 3; colNum++) {
				/*
				 * System.out.print(xls.getCellData(testCaseName, colNum,
				 * rowNum) + " -- ");
				 */
				data[rowNum - 2][colNum] = xls.getCellData(testCaseName,
						colNum, rowNum);

			}
			System.out.println();
		}

		return data;

	}

	// checks RUnmode for dataSet
	public static String[] getDataSetRunmodes(Xls_Reader xlsFile,
			String sheetName) {
		String[] runmodes = null;
		if (!xlsFile.isSheetExist(sheetName)) {
			xlsFile = null;
			sheetName = null;
			runmodes = new String[1];
			runmodes[0] = "Y";
			xlsFile = null;
			sheetName = null;
			return runmodes;
		}
		runmodes = new String[xlsFile.getRowCount(sheetName) - 1];
		for (int i = 2; i <= runmodes.length + 1; i++) {
			runmodes[i - 2] = xlsFile.getCellData(sheetName, Constants.RUNMODE, i);
		}
		xlsFile = null;
		sheetName = null;
		return runmodes;

	}

	// REPORT AND UPDATE RESULT IN THE TEST CASE SHEET "Results" COLUMN
	public static void updateResult(Xls_Reader xls, String testCaseName,
			int row, String result) {

		xls.setCellData(testCaseName, Constants.TEST_CASE_SHEET_RESULTS, row,
				result);

	}

	// RETURN THE ROW NUMBER OF THE TEST
	public static int getRowNum(Xls_Reader xls, String id) {
		for (int i = 2; i <= xls.getRowCount(Constants.TEST_CASE_SHEET); i++) {
			String tcid = xls.getCellData(Constants.TEST_CASE_SHEET,
					Constants.TEST_CASE_ID, i);

			if (tcid.equals(id)) {
				xls = null;
				return i;
			}

		}

		return -1;
	}

}
