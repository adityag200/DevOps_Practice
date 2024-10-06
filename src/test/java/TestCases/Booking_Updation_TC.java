package TestCases;

import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.Booker.API_LISTS.Booking_Updation_API;
import com.Booker.Setup.RestAssuredSetup;
import com.Booker.TestUtils.DataProviderClass;

public class Booking_Updation_TC extends RestAssuredSetup {
	@Test(dataProviderClass= DataProviderClass.class, dataProvider="dp")

	public static void update_booking(Hashtable<String, String> data, ITestContext context)
	{
		String sheetname= "update_booking";
		testLog.get().assignAuthor("Alpana");
		testLog.get().assignCategory("Functional Test");
		testLog.get().info("Verify Update booking functionality");
		Booking_Updation_API.update_booking(data, context, sheetname);
	}
	
}

