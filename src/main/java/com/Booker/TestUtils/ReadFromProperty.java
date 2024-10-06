package com.Booker.TestUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadFromProperty 
{
	public static Logger log = Logger.getLogger(ReadFromProperty.class);
	public static Properties props = null;
	public static String filepath = "./Properties/configuration.properties";
	
	public static String getProperty(String configname) {
		initProp(filepath);
		return props.getProperty(configname);
	}
	
	private static void initProp(String filepath) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			if (props == null)
				props = new Properties();
			props.load(reader);
		} catch (FileNotFoundException e) {
			log.error("file not found " + filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
