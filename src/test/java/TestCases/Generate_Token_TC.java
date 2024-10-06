package TestCases;

import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.Booker.API_LISTS.Generate_Token_API;
import com.Booker.Setup.RestAssuredSetup;
import com.Booker.TestUtils.DataProviderClass;

public class Generate_Token_TC extends RestAssuredSetup {
	@Test(dataProviderClass= DataProviderClass.class, dataProvider="dp")
	
	public static void create_token(Hashtable<String, String>data, ITestContext context) {
		String sheetname = "create_token";
		testLog.get().assignAuthor("Alpana");
		testLog.get().assignCategory("Functional Test");
		testLog.get().info("Verifying generate token functionality");
		
		Generate_Token_API.create_token(data, context,sheetname);
		
	}

}
