package com.selenium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.selenium.util.Xls_Reader;

public class TestBase {

	public static Logger APP_LOGS = null;
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static Xls_Reader suiteXls = null;
	public static Xls_Reader suiteAxls = null;
	public static Xls_Reader suiteBxls = null;
	public static Xls_Reader suiteCxls = null;
	public static boolean isInitialized = false;
	public static boolean fail=false;
	public static boolean pass=false;
	public boolean skip=false;

	// INITIALIZES THE LOGS, CONFIG, OR ,XLS, WEBDRIVER ETC....
	public static void initialize() throws IOException {

		if (!isInitialized) {

			// INITIALIZE LOG
			APP_LOGS = Logger.getLogger("devpinoyLogger");

			// INITIALIZE config

			APP_LOGS.debug("********** Let the testing Begin **********");
			APP_LOGS.debug("Loading Properties files");
			CONFIG = new Properties();
			FileInputStream ip_config = new FileInputStream(
					System.getProperty("user.dir")
							+ "\\src\\com\\selenium\\config\\config.properties");
			CONFIG.load(ip_config);
			System.out.println(CONFIG.get("testSiteName"));

			// INITIALIZE OR
			OR = new Properties();
			FileInputStream ip_or = new FileInputStream(
					System.getProperty("user.dir")
							+ "\\src\\com\\selenium\\config\\or.properties");
			OR.load(ip_or);
			System.out.println(OR.get("test"));

			APP_LOGS.debug("Loading Properties files successful");

			// INITIALIZE xls
			suiteXls = new Xls_Reader(System.getProperty("user.dir")
					+ "\\src\\com\\selenium\\xls\\Suite.xlsx");
			suiteAxls = new Xls_Reader(System.getProperty("user.dir")
					+ "\\src\\com\\selenium\\xls\\A suite.xlsx");
			suiteBxls = new Xls_Reader(System.getProperty("user.dir")
					+ "\\src\\com\\selenium\\xls\\B suite.xlsx");
			suiteCxls = new Xls_Reader(System.getProperty("user.dir")
					+ "\\src\\com\\selenium\\xls\\C suite.xlsx");

			APP_LOGS.debug("Xls files loaded successfully");
			
			isInitialized=true;

			// WebDriver
		}

	}

}
