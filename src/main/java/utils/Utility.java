package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
	public static Object fetchPropertyValue(String key) throws IOException {
		
		FileInputStream file = new FileInputStream("./Config/config.properties");
		Properties properties = new Properties();
		
		properties.load(file);
		return properties.get(key);
		
	}
	
public static String fetchLocatorValue(String key) throws IOException {
		
		FileInputStream file = new FileInputStream("./Config/elements.properties");
		Properties properties = new Properties();
		
		properties.load(file);
		return properties.get(key).toString();
		
	}

}
