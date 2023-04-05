package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.constants.EnvironmentType;

public class PropertyManager {

	static Properties  props;
	public static  Properties propertyLoader() {
		
		
		props = new Properties();
		FileInputStream input=null;
		String propertiesFileName=null;
		
		String env = System.getProperty("env", String.valueOf(EnvironmentType.UAT1));
		
		switch(EnvironmentType.valueOf(env)) {
		
		case UAT1:
			 propertiesFileName=System.getProperty("user.dir")+"/src/test/resources/uat1_config.properties";
			 break;

		case UAT2:
			 propertiesFileName=System.getProperty("user.dir")+"/src/test/resources/uat2_config.properties";
			 break;
			 
		case SIT:
			 propertiesFileName=System.getProperty("user.dir")+"/src/test/resources/sit_config.properties";
			 break;
		
		default:
			throw new IllegalStateException("Invalid environment name:"+ env);
		
		}
		
		
		try {
			input = new FileInputStream(propertiesFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to find config.properties file in root folder :"+propertiesFileName);
		}
		try {
			props.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load the properties from given file");
		}
		
		return props;
	
}

}