package com.gmail.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
 
	public  Properties pro;
	
	public ConfigDataProvider() {
		File fileName=new File(".\\Configuration\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(fileName);
		pro=  new Properties();
		pro.load(fis);

		}catch(Exception e) {
			System.out.println("Config file not loaded"+e.getMessage());
		}
		
	}
	public String getConfigData(String key) {
		String value = pro.getProperty(key);
		return value;
	}
	public String getBrowserData() {
		String browser = pro.getProperty("Browser");
		return browser;
	}
	public String geturl() {
		String url = pro.getProperty("qaurl");
		return url;
	}
}
