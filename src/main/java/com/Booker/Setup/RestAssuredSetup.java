package com.Booker.Setup;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;

public class RestAssuredSetup extends BaseSetup {
	static ITestContext context;

	@BeforeSuite(alwaysRun = true)
	public void configure() {
	
		
	//Booker Base URL	

		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

	}
}
