package com.pixere.desktop.automation.test.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
	
	private static Properties props;

	public final static String configFile = "config.properties";
	public final static String dateFormate = "yyyyMMddHHmm";
	public final static String processedFile = "Processed_";
	public static final int DEFAULT_IMPLICIT_WAIT_TIMEOUT = 10;
	public static final int DEFAULT_WAIT_TIMEOUT = 1;
	
	static {
		try {
			init();
		} catch (IOException e) {
			System.exit(1);
		}
	}
	
	private static void init() throws IOException {
		props = new Properties();
		InputStream is = new FileInputStream(configFile);
		props.load(is);
	}
	

	/**
	 * Function to get imageLocationPath Path
	 * @return imageConverterLocation
	 */
	
	public static String getimageConverterLocationPath(){
		return props.getProperty("imageConverterLocation");
	}
	
	/**
	 * Function to get imageLocationPath Path
	 * @return imageLocationPath
	 */
	
	public static String getimageLocationPath(){
		return props.getProperty("imageLocationPath");
	}
	
	/**
	 * Function to get outputImageFormate
	 * @return outputImageFormate
	 */
	
	public static String getoutputImageFormate(){
		return props.getProperty("outputImageFormate");
	}
	
	/**
	 * Function to get winiumDriverPath
	 * @return winiumDriverPath
	 */
	
	public static String getwiniumDriverPath(){
		return props.getProperty("winiumDriverPath");
	}
	
		
		
}
