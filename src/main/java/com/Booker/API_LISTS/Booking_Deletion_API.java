package com.Booker.API_LISTS;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.ITestContext;
import com.Booker.TestUtils.ExcelReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Booking_Deletion_API {

	static ExcelReader er = new ExcelReader("./testdata/TestData.xlsx");
	
	//Function to Delete booking through delete API
	public static void delete_booking(Hashtable<String, String> data, ITestContext context, String sheetname)
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Cookie", "token="+Generate_Token_API.generated_token);
		System.out.println("URL is " +RestAssured.baseURI +data.get("endpoint") + "/" +Booking_Creation_API.bookingID);
		Response response = request.log().all().delete(data.get("endpoint"));
		if(response.getStatusCode()==200) {
			Assert.assertEquals(response.getStatusCode(), 200);
			System.out.println(response.getBody().prettyPeek().asString());
		}
	}

}
