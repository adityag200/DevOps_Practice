package com.Booker.POJO;

public class Create_Booking_POJO {

	private String firstname;
	private String lastname;
	private String totalprice;
	boolean depositpaid;
	private String additionalneeds;
	private Booking_bookingDates_POJO bookingdates;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	public Booking_bookingDates_POJO getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(Booking_bookingDates_POJO bookingdates) {
		this.bookingdates = bookingdates;
	}
}
