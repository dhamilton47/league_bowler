package com.tsksolutions.leaguebowler;

public class GoodStudent extends Person implements Knowledgeable{
	private String major;
	private String level;
	
	public GoodStudent(String lastName, String firstName, String middleName,
			String addressLine1, String addressLine2, String city, String state, String zipCode,
			String phoneNumber, String email, String major, String level) {
		super(lastName, firstName, middleName, addressLine1, addressLine2, city, state, zipCode,
				phoneNumber, email);
		this.major = major;
		this.level = level;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n\tStudent [major = " + major + ", level = " + level + "]";
	}
	
	@Override
	public void someMethod() {
		System.out.println("This action comes from someMethod(GoodStudent).");	
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}

	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public void StudyHours() {
		System.out.println(super.getFirstName() + " spends lots of time studying.");
	}

	@Override
	public void readBook() {
		System.out.println(super.getFirstName() + " reads lots of books.");
		
	}

	@Override
	public void classParticipation() {
		System.out.println(super.getFirstName() + " regularly attends class.");
	}
	
}
