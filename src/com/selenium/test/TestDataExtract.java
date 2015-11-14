package com.selenium.test;

import com.selenium.config.Constants;
import com.selenium.util.Xls_Reader;

public class TestDataExtract {

	public static void main(String[] args) {

		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")
				+ "\\src\\com\\selenium\\xls\\" + Constants.TEST_CASE_A);

		getData(xl, "TestCase_A2");

	}
	
	
	//RETURN DATA FROM TEST DATA SHEET IF THE SHEET EXISTS
	public static Object[][] getData(Xls_Reader xls, String testCaseName) {

		if (!xls.isSheetExist(testCaseName)) {
			return new Object[1][0];
		}

		int row = (xls.getRowCount(testCaseName));
		int col = xls.getColumnCount(testCaseName);

		System.out.println("Rows -- " + row + " || Cols -- " + col);
		
		Object[][] data = new Object[row-1][col-3];

		for (int rowNum = 2; rowNum <= row; rowNum++) {
			for (int colNum = 0; colNum < col - 3; colNum++) {
				/*System.out.print(xls.getCellData(testCaseName, colNum, rowNum)
						+ " -- ");*/
				data[rowNum-2][colNum]=xls.getCellData(testCaseName, colNum, rowNum);
				
			}
			System.out.println();
		}

		return data;

	}

}
