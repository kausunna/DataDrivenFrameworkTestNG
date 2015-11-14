package com.selenium.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigInitialize {

	public static void main(String[] args) throws IOException {
		
		//config
		Properties CONFIG = new Properties();
		FileInputStream ip_config = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\selenium\\config\\config.properties");
		CONFIG.load(ip_config);
		System.out.println(CONFIG.get("testSiteName"));
		
		//OR
		Properties OR = new Properties();
		FileInputStream ip_or = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\selenium\\config\\or.properties");
		OR.load(ip_or);
		System.out.println(OR.get("test"));
		
	}

}
