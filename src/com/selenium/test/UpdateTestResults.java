package com.selenium.test;

import com.selenium.config.Constants;
import com.selenium.util.Xls_Reader;

public class UpdateTestResults {

	public static void main(String[] args) {
		
		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")
				+ "\\src\\com\\selenium\\xls\\" + Constants.TEST_CASE_A);

		updateResult(xl, "TestCase_A1", 3, "PASS");


	}
	
	public static void updateResult(Xls_Reader xls,String testCaseName,int row,String result){
		
		xls.setCellData(testCaseName, "Results", row, result);
		
	}

}
