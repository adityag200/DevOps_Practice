package com.Booker.JSON_Creation;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.testng.ITestContext;

import com.Booker.POJO.Create_Token_POJO;
import com.Booker.Setup.RestAssuredSetup;
import com.google.gson.Gson;

public class Create_Token_JSON {
	
	static Create_Token_POJO token = new Create_Token_POJO();
	static RestAssuredSetup ras = new RestAssuredSetup();
 
	@SuppressWarnings({ "rawtypes", "static-access" })
	public String token_creation(Hashtable<String, String> map, ITestContext context)
	{
		String jsonString=null;
		Set keys = map.keySet();
		Iterator itr = keys.iterator();
		//System.out.println("The value of Itr "+itr.hasNext());
		String key;
		String value;
		while(itr.hasNext())
		{
			key = (String) itr.next();
			value = map.get(key);

			if(key.equals("username"))
			{	
				token.setUsername(value);

			}	else if (key.equals("password"))
			{	
				token.setPassword(value);
			}
		}		
			Gson gSon = new Gson();
			jsonString = gSon.toJson(token);
			return jsonString;

		}
	
}
