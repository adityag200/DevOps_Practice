package com.Booker.ENUMS;

import java.util.HashMap;
import java.util.Map;

public class TestContext
{
	public Map<String,Object> testContext;
	
	public TestContext()
	{
		testContext= new HashMap<String, Object>();
	}
	
	public void setContext(String string, Object value)
	{
		testContext.put(string.toString(), value);
	}
	
	public Object getContext(String key)
	{
		return testContext.get(key.toString());
	}
	
}
