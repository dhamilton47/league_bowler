package com.tsksolutions.leaguebowler.model;

//import java.time.LocalDate;

//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//import com.tsksolutions.leaguebowler.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Dan J. Hamilton
 */
abstract public class Person {
	private static int index = 0;
	private int id;
	private StringProperty lastName;
	private StringProperty firstName;
	private StringProperty middleName;
	private StringProperty addressLine1;
	private StringProperty addressLine2;
	private StringProperty city;
	private StringProperty state;
	private IntegerProperty zipCode;
	private StringProperty phoneNumber;
	private StringProperty email;
	
	//Constructor
    /**
     * Default constructor.
     */
    public Person() {
        this(null, null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName, String middleName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.middleName = new SimpleStringProperty(middleName);

        // Some initial dummy data, just for convenient testing.
        this.addressLine1 = new SimpleStringProperty("some street");
        this.addressLine2 = new SimpleStringProperty("some apartment");
        this.city = new SimpleStringProperty("some city");
        this.state = new SimpleStringProperty("FL");
        this.zipCode = new SimpleIntegerProperty(34787);
        this.phoneNumber = new SimpleStringProperty("407-555-1111");
        this.email = new SimpleStringProperty("name@domain");
		this.id = index++;
//        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     * @param middleName
     * @param addressLine1
     * @param addressLine2
     * @param city
     * @param state
     * @param zipCode
     * @param phoneNumber
     * @param email
     */
	public Person(String lastName, String firstName, String middleName,
			String addressLine1, String addressLine2, String city, String state, int zipCode,
			String phoneNumber, String email) { 
		super();
		this.lastName = new SimpleStringProperty(lastName);
		this.firstName = new SimpleStringProperty(firstName);
		this.middleName = new SimpleStringProperty(middleName);
		this.setAddressLine1(addressLine1);
		this.setAddressLine2(addressLine2);
		this.city = new SimpleStringProperty(city);
		this.setState(state);
		this.setZipCode(zipCode);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
		this.id = index++;
	}
	
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public String getAddressLine1() {
        return addressLine1.get();
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1.set(addressLine1);
    }

    public StringProperty addressLine1Property() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2.get();
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2.set(addressLine2);
    }

    public StringProperty addressLine2Property() {
        return addressLine2;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public StringProperty stateProperty() {
        return state;
    }

    public int getZipCode() {
        return zipCode.get();
    }

    public void setZipCode(int zipCode) {
        this.zipCode.set(zipCode);
    }

    public IntegerProperty zipCodeProperty() {
        return zipCode;
    }

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}

	public StringProperty phoneNumber() {
		return phoneNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email.get();
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email.set(email);
	}

	public StringProperty email() {
		return email;
	}
/*
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
*/    
    public void someMethod() {
		System.out.println("This action comes from someMethod(Person).");
	}
	
	abstract public void StudyHours();
	
	//Getters and Setters
	public String Class() {
		return "Person";
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName + " (" + id + ") from " + city;
	}
}
