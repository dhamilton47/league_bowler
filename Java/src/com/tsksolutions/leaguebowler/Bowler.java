package com.tsksolutions.leaguebowler;

public class Bowler extends Person {

	public Bowler(String lastName, String firstName, String middleName,
			String addressLine1, String addressLine2, String city, String state, String zipCode,
			String phoneNumber, String email) {
		super(lastName, firstName, middleName, addressLine1, addressLine2, city, state, zipCode,
				phoneNumber, email);
	}

	@Override
	public void StudyHours() {
		System.out.println(super.getFirstName() + " spends lots of time studying.");
	}

	@Override
	public String Class() {
		return "Bowler";
	}
	
	@Override
	public String toString() {// display class name and person's name
		return "Object Class:\t\t" + this.Class() + "\nName:\t\t" + super.getLastName() + ", " + super.getFirstName() + " " + super.getMiddleName();
	}
}
