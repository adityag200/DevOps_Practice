package com.Booker.TestUtils;

import java.lang.reflect.Method;
import java.util.Hashtable;

import com.Booker.Setup.BaseSetup;

public class DataProviderClass extends BaseSetup
{
	@org.testng.annotations.DataProvider(name = "dp")
	public Object[][] getData(Method method) throws NegativeArraySizeException
	
	{
		
		String sheetName = method.getName();		
		int rowCount = excel.getRowCount(sheetName);
		
		//System.out.println(sheetName);	
		//System.out.println(rowCount);	
		
		int columnCount = excel.getColumnCount(sheetName);
		System.out.println("row count:"+rowCount);
		//System.out.println("colum count: "+columnCount);
		
		Object[][] data = new Object[rowCount-1][1];
		
		
		Hashtable<String, String> table = null;
		
		for(int rowNum =2; rowNum<=rowCount; rowNum++)
		{
			table = new Hashtable<String, String>();
			for(int cellNum =0; cellNum<columnCount; cellNum++)
			{
				table.put(excel.getCellData(sheetName, cellNum, 1), excel.getCellData(sheetName, cellNum, rowNum));
				data[rowNum-2][0]= table; 
				
				//System.out.println(data[rowNum-2][0]);
			}
		}	
		
		//System.out.println(data);
		
		return data;
		
	}

}
