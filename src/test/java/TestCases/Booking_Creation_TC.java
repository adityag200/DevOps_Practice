package TestCases;

import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.Booker.API_LISTS.Booking_Creation_API;
import com.Booker.Setup.RestAssuredSetup;
import com.Booker.TestUtils.DataProviderClass;

public class Booking_Creation_TC extends RestAssuredSetup{
	@Test(dataProviderClass= DataProviderClass.class, dataProvider="dp")

	public static void create_booking(Hashtable<String, String> data, ITestContext context)
	{
		String sheetname= "create_booking";
		testLog.get().assignAuthor("Alpana");
		testLog.get().assignCategory("Functional Test");
		testLog.get().info("Verify Create booking functionality");
		Booking_Creation_API.create_booking(data, context, sheetname);
	}
}
