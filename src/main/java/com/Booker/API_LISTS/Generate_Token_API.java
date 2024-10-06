package com.Booker.API_LISTS;

import java.util.Hashtable;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.ITestContext;
import com.Booker.JSON_Creation.Create_Token_JSON;
import com.Booker.TestUtils.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Generate_Token_API {

	static ExcelReader er = new ExcelReader("./testdata/TestData.xlsx");
	static String generated_token;
    
	//Function to generate token through POST API
	public static void create_token(Hashtable<String, String> data, ITestContext context, String sheetname) {
		RequestSpecification request = RestAssured.given();
		Create_Token_JSON token = new Create_Token_JSON();
		String reqBody = token.token_creation(data, context);
		System.out.println("Request body is: "+reqBody);
		request.header("Content-Type", "application/json");
		request.body(reqBody);
		System.out.println("URL is  " + RestAssured.baseURI +data.get("endpoint"));
		Response response = request.log().all().post(data.get("endpoint"));
		JsonPath jsonPathEvaluator = response.jsonPath(); 
		if(response.getStatusCode()==200) {
			Assert.assertEquals(response.getStatusCode(), 200);
			System.out.println(response.getBody().prettyPeek().asString());
			generated_token = jsonPathEvaluator.get("token");
			System.out.println("Token is "+generated_token);
		}
		else {
			System.out.println("Bad credentials "+jsonPathEvaluator.get("reason"));
		}
	}

}
	

