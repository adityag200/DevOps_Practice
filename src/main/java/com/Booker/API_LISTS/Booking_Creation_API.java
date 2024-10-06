package com.Booker.API_LISTS;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.ITestContext;

import com.Booker.JSON_Creation.Create_Booking_JSON;
import com.Booker.TestUtils.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Booking_Creation_API {

	static ExcelReader er = new ExcelReader("./testdata/TestData.xlsx");
	static int bookingID;
	
	//Function to Register booking through POST API
	public static void create_booking(Hashtable<String, String> data, ITestContext context, String sheetname)
	{
		RequestSpecification request = RestAssured.given();
		Create_Booking_JSON create_booking = new Create_Booking_JSON();
		String reqBody = create_booking.booking_creation(data, context);
		System.out.println("Request body is "+reqBody);
		request.header("Content-Type", "application/json");
		request.header("Cookie", "token="+Generate_Token_API.generated_token);
		request.body(reqBody);
		System.out.println("URL is "+RestAssured.baseURI+data.get("endpoint"));
		Response response = request.log().all().post(data.get("endpoint"));
		JsonPath jsonPathEvaluator = response.jsonPath();
		if(response.getStatusCode()==200) {
			Assert.assertEquals(response.getStatusCode(), 200);
			System.out.println(response.getBody().prettyPeek().asString());
			bookingID= jsonPathEvaluator.get("bookingid");
			System.out.println("Booking Id is "+bookingID);
		}
	}
	
}
