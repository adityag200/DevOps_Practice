package com.Booker.JSON_Creation;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.testng.ITestContext;

import com.Booker.POJO.Booking_bookingDates_POJO;
import com.Booker.POJO.Create_Booking_POJO;
import com.Booker.Setup.RestAssuredSetup;

import gherkin.deps.com.google.gson.Gson;

public class Create_Booking_JSON {

	static Create_Booking_POJO booking = new Create_Booking_POJO();
	static Booking_bookingDates_POJO bookingDate = new Booking_bookingDates_POJO();
	static RestAssuredSetup ras = new RestAssuredSetup();
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	public String booking_creation(Hashtable<String, String> map, ITestContext context)
	{
		String jsonString=null;
		Set keys = map.keySet();
		Iterator itr = keys.iterator();
		String key;
		String value;
		while(itr.hasNext()) {
			key = (String) itr.next();
			value = map.get(key);
			
			if(key.equals("firstname")) {
				booking.setFirstname(value);
			}else if(key.equals("lastname")) {
				booking.setLastname(value);
			}else if(key.equals("totalprice")) {
				booking.setTotalprice(value);
			}else if(key.equals("depositpaid")) {
				boolean value1 = Boolean.valueOf(value);
				booking.setDepositpaid(value1);
			}else if(key.equals("additionalneeds")) {
				booking.setAdditionalneeds(value);
			}else if(key.equals("checkin")) {
				booking.setBookingdates(bookingDate);
				bookingDate.setCheckin(value);
			}else if(key.equals("checkout")) {
				booking.setBookingdates(bookingDate);
				bookingDate.setCheckout(value);
			}
			
		}
		Gson gson = new Gson();
		jsonString = gson.toJson(booking);
		return jsonString;
	}
}
