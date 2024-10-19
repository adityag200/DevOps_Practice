package TestCases;

import java.util.Hashtable;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.Booker.API_LISTS.Booking_GetRequest_API;
import com.Booker.Setup.RestAssuredSetup;
import com.Booker.TestUtils.DataProviderClass;

public class Booking_GetRequest_TC extends RestAssuredSetup {
	@Test(dataProviderClass= DataProviderClass.class, dataProvider="dp")

	public static void get_booking(Hashtable<String, String> data, ITestContext context)
	{
		String sheetname= "get_booking";
		testLog.get().assignAuthor("Alpana");
		testLog.get().assignCategory("Functional Test");
		testLog.get().info("Verify get booking functionality");
		Booking_GetRequest_API.get_booking(data, context, sheetname);
	}
}	
