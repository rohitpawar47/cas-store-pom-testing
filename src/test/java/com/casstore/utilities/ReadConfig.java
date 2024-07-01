package com.casstore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	
	String path = "/Users/rohitpawar/Documents/automation-workspace/CASStore/configuration/config.properties";
	
//	Constructor
	public ReadConfig() {
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String getBaseUrl() {
		String val = properties.getProperty("baseUrl");
		if(val!=null)
			return val;
		else
			throw new RuntimeException("Url is specified in config file");
	}
	
	public String getBrowser() {
		String val = properties.getProperty("browser");
		if(val!=null)
			return val;
		else
			throw new RuntimeException("Browser is specified in config file");
	}
}
