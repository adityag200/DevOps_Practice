package com.Booker.Setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import com.Booker.TestUtils.Environment;
import com.Booker.TestUtils.ExcelReader;
import com.Booker.TestUtils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseSetup
{
	public int lStartTime;
	public int lEndTime;
	public static Logger log = Logger.getLogger(BaseSetup.class);
	//public static ExcelReader excel = new ExcelReader("./testdata/TestData_Common.xlsx");
	public static ExcelReader excel = new ExcelReader("./testdata/TestData.xlsx");
	public static Properties config = new Properties();
	public static ExtentReports extent;
	
	/*
	 * public static ThreadLocal<ExtentTest> parentTest= new
	 * ThreadLocal<ExtentTest>(); public static ThreadLocal<ExtentTest> testLog =
	 * new ThreadLocal<ExtentTest>();
	 */
	 
	
	
	  public static InheritableThreadLocal<ExtentTest> parentTest= new InheritableThreadLocal<ExtentTest>(); 
	  public static InheritableThreadLocal<ExtentTest> testLog = new InheritableThreadLocal<ExtentTest>();
	 
	
	public Map<String, ExtentTest> map = new HashMap<String, ExtentTest>();
	
	public static Properties configProperty;
	
	public static String propertyFilepath ="./propertiesFiles/config.properties";
	
	@BeforeSuite(alwaysRun=true)
	public void setup()
	{
		log.info("Starting execution of BeforeSuite ");
		try {
			FileInputStream fi = new FileInputStream(new File(propertyFilepath));
			configProperty = new Properties();
			try {
				configProperty.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent = ExtentManager.GetExtent();	
	}

	@Parameters({ "env" })
	@BeforeTest(alwaysRun=true)
	public void beforeTest(String environment)
	{
		log.info("Starting execution ");
		lStartTime = (int) new Date().getTime();
		
		switch (environment) {
		case Environment.QA:
			System.setProperty(com.Booker.TestUtils.Properties.ENVIRONMENT, Environment.QA);
			break;

		default:
			log.error("Please rerun again and enter correct environment.");
			Assert.fail("Could not execute the scripts due to incorrect evironment specified");
			break;
		}
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforClass()
	{
		log.info("Starting execution before class");
		String className = getClass().getName();
		className= className.substring(className.lastIndexOf(".")+1);
		ExtentTest parent = extent.createTest(className);
		parentTest.set(parent);
		
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		;
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		extent.flush();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		
	}
	
	public void assertStatusCode(int statusCode, String expectedStatusCode)
	{
		String expectedcode = expectedStatusCode.split(".")[0];
		Assert.assertEquals(Integer.toString(statusCode), expectedcode);
	}
	
	public String getExpStatusCode(String expectedcode) 
	{
		return expectedcode.substring(0, expectedcode.indexOf('.'));
		
	}
	
	public void assignAuthor(String authorName)
	{
		testLog.get().assignAuthor(authorName);
	}
	
	public void assignCategory(String category)
	{
		testLog.get().assignCategory(category);
	}

}
